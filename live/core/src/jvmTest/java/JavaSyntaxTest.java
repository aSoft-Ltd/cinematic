import cinematic.MutableLiveFactory;
import koncurrent.MockExecutors;
import cinematic.Live;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

import cinematic.MutableLive;

import static kommander.ExpectBuilders.*;

public class JavaSyntaxTest {

    private final Executor executor = MockExecutors.create();

    private void print(final int watcherNo, final int value) {
        System.out.println("Watcher " + watcherNo + ": " + value);
    }

//    @Test
//    public void should_have_a_valid_syntax_for_live() {
//        Live<Integer> liveInt = create(4);
//        var watcher = liveInt.watch(p -> {
//            return print(1, p);
//        });
//        watcher.stop();
//    }
//
//    @Test
//    public void should_have_a_valid_syntax_for_mutable_live() {
//        MutableLive<Integer> liveInt = create(1);
//        final var value1 = new AtomicInteger(0);
//        liveInt.watch(x -> {
//            var p = x;
//            return System.out.println(x);
//        });
//        var watcher1 = liveInt.watch(x -> {
//            value1.set(x);
//            return print(1, x);
//        }, WatchMode.Casually, executor);
//        expect(value1.get()).toBe(0);
//        liveInt.setValue(2);
//        expect(value1.get()).toBe(2);
//        liveInt.setValue(3);
//        expect(value1.get()).toBe(3);
//
//        final var value2 = new AtomicInteger(0);
//        var watcher2 = liveInt.watch(x -> {
//            value2.set(x);
//            print(2, x);
//        }, WatchMode.Eagerly, executor);
//        expect(value2.get()).toBe(3);
//        liveInt.setValue(4);
//        expect(value1.get()).toBe(4);
//        expect(value2.get()).toBe(4);
//        liveInt.setValue(5);
//        expect(value1.get()).toBe(5);
//        expect(value2.get()).toBe(5);
//        watcher1.stop();
//        liveInt.setValue(6);
//        expect(value1.get()).toBe(5);
//        expect(value2.get()).toBe(6);
//        liveInt.setValue(7);
//        expect(value1.get()).toBe(5);
//        expect(value2.get()).toBe(7);
//        watcher2.stop();
//        liveInt.setValue(8);
//        expect(value1.get()).toBe(5);
//        expect(value2.get()).toBe(7);
//        watcher2.stop();
//        liveInt.setValue(9);
//        liveInt.setValue(10);
//        expect(value1.get()).toBe(5);
//        expect(value2.get()).toBe(7);
//    }
}
