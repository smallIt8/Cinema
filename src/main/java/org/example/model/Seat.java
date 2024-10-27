package org.example.model;

public enum Seat {
    SEAT_ONE(1),
    SEAT_TWO(2),
    SEAT_THREE(3),
    SEAT_FOUR(4),
    SEAT_FIVE(5),
    SEAT_SIX(6),
    SEAT_SEVEN(7),
    SEAT_EIGHT(8),
    SEAT_NINE(9),
    SEAT_TEN(10),
    SEAT_ELEVEN(11),
    SEAT_TWELVE(12),
    SEAT_THIRTEEN(13),
    SEAT_FOURTEEN(14),
    SEAT_FIFTEEN(15),
    SEAT_SIXTEEN(16),
    SEAT_SEVENTEEN(17),
    SEAT_EIGHTEEN(18),
    SEAT_NINETEEN(19),
    SEAT_TWENTY(20),
    SEAT_TWENTY_ONE(21),
    SEAT_TWENTY_TWO(22),
    SEAT_TWENTY_THREE(23),
    SEAT_TWENTY_FOUR(24),
    SEAT_TWENTY_FIVE(25),
    SEAT_TWENTY_SIX(26),
    SEAT_TWENTY_SEVEN(27),
    SEAT_TWENTY_EIGHT(28),
    SEAT_TWENTY_NINE(29),
    SEAT_THIRTY(30),
    SEAT_THIRTY_ONE(31),
    SEAT_THIRTY_TWO(32),
    SEAT_THIRTY_THREE(33),
    SEAT_THIRTY_FOUR(34),
    SEAT_THIRTY_FIVE(35),
    SEAT_THIRTY_SIX(36),
    SEAT_THIRTY_SEVEN(37),
    SEAT_THIRTY_EIGHT(38),
    SEAT_THIRTY_NINE(39),
    SEAT_FORTY(40),
    SEAT_FORTY_ONE(41),
    SEAT_FORTY_TWO(42),
    SEAT_FORTY_THREE(43),
    SEAT_FORTY_FOUR(44),
    SEAT_FORTY_FIVE(45),
    SEAT_FORTY_SIX(46),
    SEAT_FORTY_SEVEN(47),
    SEAT_FORTY_EIGHT(48),
    SEAT_FORTY_NINE(49),
    SEAT_FIFTY(50);

    private final int number;

    Seat(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
    public static Seat fromNumber(int number) {
        for (Seat seat : values()) {
            if (seat.getNumber() == number) {
                return seat;
            }
        }
        return null;
    }
}