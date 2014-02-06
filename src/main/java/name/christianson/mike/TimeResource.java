package name.christianson.mike;

import com.google.common.base.Optional;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Path("/time")
@Produces(MediaType.APPLICATION_JSON)
public class TimeResource {
    private final String defaultTimezone;

    public TimeResource(String defaultTimezone) {
        this.defaultTimezone = defaultTimezone;
    }

    @GET
    public Time getTime(@QueryParam("timezone") Optional<String> timezone) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone(timezone.or(defaultTimezone));
        formatter.setTimeZone(timeZone);
        String formatted = formatter.format(new Date());
        return new Time(formatted);
    }
}