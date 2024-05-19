import org.junit.Test;
import static org.junit.Assert.*;
public class SubscriptionTest {
    @Test
    public void testCalculateSubscription_JuniorMember() {
        Member juniorMember = new Member("John", "Wick", 15, true, false, false);
        Subscription subscription = new Subscription();
        assertEquals(1000, subscription.calculateSubscription(juniorMember));
    }

    @Test
    public void testCalculateSubscription_AdultMember() {
        Member adultMember = new Member("Jane", "Foster", 30, true, false, false);
        Subscription subscription = new Subscription();
        assertEquals(1600, subscription.calculateSubscription(adultMember));
    }

    @Test
    public void testCalculateSubscription_SeniorMember() {
        Member seniorMember = new Member("Joe", "Defoe", 65, true, true, true);
        Subscription subscription = new Subscription();
        assertEquals(1200, subscription.calculateSubscription(seniorMember)); // 1600 * 0.75
    }

    @Test
    public void testCalculateSubscription_PassiveMember() {
        Member passiveMember = new Member("Jill", "Samson", 40, false, false, false);
        Subscription subscription = new Subscription();
        assertEquals(500, subscription.calculateSubscription(passiveMember));
    }

    @Test
    public void testCalculateSubscription_SeniorButNotActive() {
        Member seniorNotActive = new Member("Jack", "Sparrow", 70, false, true, false);
        Subscription subscription = new Subscription();
        assertEquals(500, subscription.calculateSubscription(seniorNotActive)); // Passive member rate
    }
}