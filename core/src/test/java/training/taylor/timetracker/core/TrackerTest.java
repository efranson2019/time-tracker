package training.taylor.timetracker.core;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import training.taylor.timetracker.core.dao.TimeEntry;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by Jason on 6/19/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TrackerCoreConfig.class)
public class TrackerTest {
    @Autowired
    private Tracker tracker;
    private Log log = LogFactory.getLog(TrackerTest.class);

    @Test
    public void testMe() {
        assertNotNull(tracker);
        log.info("tracker.size()=" + tracker.size().toString());
    }

    @Test
    public void testAdd() {        
        TimeEntry entry = new TimeEntry();
        entry.setDescription("Entry Test");
        entry.setRate(80.0f);
        entry.setTime(3);
        int initialSize = tracker.size();
        log.info("tracker.size()=" + tracker.size().toString());
        tracker.add(entry); 
        assertEquals("tracker.size()", initialSize+1, tracker.size());
        log.info("tracker.size()=" + tracker.size().toString());
    }
}
