package com.akabynga.multithreading.course.notifyall.messagetransport.broker;

import com.akabynga.multithreading.course.notifyall.messagetransport.model.Message;

import java.util.ArrayDeque;
import java.util.Optional;
import java.util.Queue;

public final class MessageBroker {

    private static final String MESSAGE_OF_MESSAGE_IS_PRODUCED = "Message '%s' is produced.\n";
    private static final String MESSAGE_OF_MESSAGE_IS_CONSUMED = "Message '%s' is consumed.\n";

    private final Queue<Message> messagesToBeConsumed;
    private final int maxStoreMessages;

    public MessageBroker(final int maxStoreMessages) {
        this.messagesToBeConsumed = new ArrayDeque<>(maxStoreMessages);
        this.maxStoreMessages = maxStoreMessages;
    }

    public synchronized void produce(final Message message) {
        try {
            while (this.messagesToBeConsumed.size() >= this.maxStoreMessages) {
//                super.wait(1000);
                super.wait();
            }
            this.messagesToBeConsumed.add(message);
            System.out.printf(MESSAGE_OF_MESSAGE_IS_PRODUCED, message);
            super.notifyAll();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized Optional<Message> consume() {
        try {
            while (this.messagesToBeConsumed.isEmpty()) {
//                super.wait(1000);
                super.wait();
            }
            Message consumedMessage = this.messagesToBeConsumed.poll();
            System.out.printf(MESSAGE_OF_MESSAGE_IS_CONSUMED, consumedMessage);
            super.notifyAll ();
            return Optional.ofNullable(consumedMessage);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return Optional.empty();
        }
    }

}
