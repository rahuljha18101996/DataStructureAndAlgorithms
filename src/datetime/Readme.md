Epoch Start -> January 1, 1970 UTC (Midnight)

UTC - Coordinated Universal Time
> Timekeeping by civil world
> Used bt servers,air traffic control, international space station
> Typical UTC day ~ 86400 seconds
Occasionally ~ 86401 or 86399 secs
Earth Wobbling(leap seconds)
> Measured by atomic clock
> UT ~ Based on astronomical observations (1884). GMT

> UK    -> 0 UTC
> US    -> -8:00 UTC
> INDIA -> +5:30 UTC


Calendar System
> Solar
Gregorian (October 15, 1582) ~ Leap Year exactly divisible by 4/400, but not 100
Julian ~ Leap Year exactly divisible by 4
> Lunar ~ Islamic
> Lunisolar ~ Buddhist, Chinese, Hindu Lunisolar, Hebrew


Java 8 Date & Time API
> Follow ISO, Geneva 8601
> Proleptic Gregorian Calendar


New Date Time API
> java.Time
> Joda time
> Based on ISO-8601
> Mostly immutable classes - Thread safe
> No public constructor ~ static factories (eg. of)
> (LocalDate, LocalTime, LocalDateTime, ZonedDateTime, Instant) <- Temporal <- TemporalAccessor
> [date]T[time][zone offset]
> ZonedDateTime
2017-07-03T01:00-7:00[America/Los_Angeles]
LocalDate  LocalTime
LocalDateTime
2017-07-03T01:00Z[UTC]