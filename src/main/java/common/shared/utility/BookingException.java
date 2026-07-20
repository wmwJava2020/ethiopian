package common.shared.utility;

/**
 * Author: Wondafrash
 * Date: 7/20/2026
 * Time: 1:20 PM
 */


public class BookingException extends Exception
{
    private static final long serialVersionUID = 1L;

    public BookingException(String message) {
        super(message);    // ← add this
    }
}
