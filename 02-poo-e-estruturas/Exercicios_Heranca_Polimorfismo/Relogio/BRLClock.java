package Relogio;

public non-sealed class BRLClock extends Clock{

    @Override
    public Clock convert(final Clock clock){
        this.seconds = clock.getSeconds();
        this.minutes = clock.getMinutes();
        switch (clock){
            case USClock usClock ->{
                this.hour = (usClock.getPeriodIndicator().equals("PM")) ?
                        usClock.getHour() + 12 :
                        usClock.getHour();
            }
            case BRLClock brClock ->{
                this.seconds = brClock.getHour();
            }

        }
        return this;
    }
}
