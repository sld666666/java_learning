package java_learning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import javafx.application.Application;
import reactor.Environment;
import reactor.bus.EventBus;

import static reactor.bus.selector.Selectors.$;

/**
 * Hello world!
 *
 */
public class App implements CommandLineRunner
{
    private static final int NUMBER_OF_QUOTES = 10;


    public static void main( String[] args ) throws Exception {
        ApplicationContext app = SpringApplication.run(Application.class, args);

        app.getBean(CountDownLatch.class).await(1, TimeUnit.SECONDS);

        app.getBean(Environment.class).shutdown();
    }


    @Bean
    Environment env(){
        return   Environment.initializeIfEmpty()
                        .assignErrorJournal();
    }

    @Bean
    EventBus createEventBus(Environment env){
        return  EventBus.create(env, Environment.THREAD_POOL);
    }

    @Autowired
    private  EventBus eventBus;

    @Autowired
    private Receiver receiver;

    @Autowired
    private Publisher publisher;

    @Bean
    public CountDownLatch latch(){
        return  new CountDownLatch(NUMBER_OF_QUOTES);
    }

    @Override
    public void run(String... strings) throws Exception {
        eventBus.on($("quotes"), receiver);
        publisher.publishQuotes(NUMBER_OF_QUOTES);
    }
}
