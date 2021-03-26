package main.java.com.sergeev.task2;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.Scanner;

/**
 * Task implements the chain of responsibility pattern in the functional style for stage-by-stage request creating.
 */
public class Task2_4 {

    static RequestHandler wrapInTransactionTag = req -> new Request(String.format("<transaction>%s</transaction>",
            req.getData()));

    static RequestHandler createDigest = request -> {
        String digest = "";
        try {
            final MessageDigest md5 = MessageDigest.getInstance("MD5");
            final byte[] digestBytes = md5.digest(request.getData().getBytes(StandardCharsets.UTF_8));
            digest = new String(Base64.getEncoder().encode(digestBytes));
        } catch (Exception ignored) {
            System.out.println("An error occurred");
        }
        return new Request(request.getData() + String.format("<digest>%s</digest>", digest));
    };

    static RequestHandler wrapInRequestTag = request -> new Request(String.format("<request>%s</request>",
            request.getData()));

    static RequestHandler commonRequestHandler =
            request -> wrapInRequestTag.combine(createDigest).combine(wrapInTransactionTag).handle(request);

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String requestData = scanner.nextLine();
        final Request notCompletedRequest = new Request(requestData);
        System.out.println(commonRequestHandler.handle(notCompletedRequest).getData());
    }

    static class Request {
        private final String data;

        public Request(String requestData) {
            this.data = requestData;
        }

        public String getData() {
            return data;
        }
    }

    @FunctionalInterface
    interface RequestHandler {
        Request handle(Request request);

        default RequestHandler combine(RequestHandler requestHandler) {
            return request -> handle(requestHandler.handle(request));
        }
    }
}
