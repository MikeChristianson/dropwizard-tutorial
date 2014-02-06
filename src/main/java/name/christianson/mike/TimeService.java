package name.christianson.mike;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

public class TimeService extends Service<TimezoneConfiguration> {
    public static void main(String[] args) throws Exception {
        new TimeService().run(args);
    }

    @Override
    public void initialize(Bootstrap<TimezoneConfiguration> timezoneConfigurationBootstrap) {
    }

    @Override
    public void run(TimezoneConfiguration config, Environment environment) {
        String defaultTimezone = config.getDefaultTimezone();
        TimeResource timeResource = new TimeResource(defaultTimezone);
        environment.addResource(timeResource);
    }
}