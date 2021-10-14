import java.time.LocalDate;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test tt = new test();
		tt.getCurrentDayPlus(30); 
	}
	
	 //Get The Current Day plus days. You can change this method based on your needs.
    public  String getCurrentDayPlus(int days) {
        LocalDate currentDate = LocalDate.now(); System.out.println(currentDate);
        
        int dayOfWeekPlus = currentDate.getDayOfWeek().plus(days).getValue(); 
        System.out.println(currentDate.getDayOfWeek());
        System.out.println(currentDate.getDayOfWeek().plus(days));
        System.out.println(currentDate.getDayOfWeek().plus(days).getValue());
        
        return Integer.toString(dayOfWeekPlus);
    }

}
