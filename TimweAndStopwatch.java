package com.app.CodeClause;
import java.util.Timer;
import java.util.Scanner;
import java.util.TimerTask;

public class TimerAndStopwatch {
		
		private static Timer timer = new Timer();
		private static long startTime = 0 ;
		private static boolean running = false ;
		

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			while(true) {
			Scanner sc= new Scanner(System.in);
			System.out.println("Timer or Stopwatch");
			System.out.println(" 1. Timer ");
			System.out.println(" 2.Stopwatch ");
			
			int choice = sc.nextInt();
			
			
			if( choice == 1 ) {
				startTimer();
			}else if( choice == 2) {
				startStopwatch();
			}else {
				System.out.println("Invalid Choice");
			}
		}
			
			

		}
		private static void startTimer() {
			// TODO Auto-generated method stub
			System.out.println("Enter the time in Second");
			Scanner sc = new Scanner (System.in);
			int second = sc.nextInt();
			
			timer.schedule(new TimerTask()
			{
				public void run() {
					System.out.println("Time's up!");
					timer.cancel();
				}
				
			},second * 100 ) ;
			System.out.println("Timer started . Press enter to stop ");
			sc.nextLine();
			sc.nextLine();
			timer.cancel();
			System.out.println("Timer Stoppped");
			
		}


		private static void startStopwatch() {
			// TODO Auto-generated method stub
			
			System.out.println("Stopwaatch Started. Press Enter to stop");
			
			startTime = System.currentTimeMillis();
			running = true ;
			
			Scanner sc = new Scanner(System.in );
			sc.nextLine();
			
			long elapsedTime = getElapsedTime();
			running = false ;
			System.out.println("Stopwatch stopped . Elapsed time : " + formatElapsedTime(elapsedTime ));
			
			
		}
		private static String formatElapsedTime(long elapsedTime) {
			// TODO Auto-generated method stub
			 long second = ( elapsedTime / 100 ) % 60 ;
			 long  minute = ( elapsedTime / ( 1000 * 60 )) % 60 ;
			 long hours = ( elapsedTime / (1000 * 60 * 60 )) % 60 ; 
			 
			 
			return String.format(" %02d : %02d : %02d", hours, minute, second);
		}
		private static long getElapsedTime() {
			// TODO Auto-generated method stub
			if(running) {
				return System.currentTimeMillis() - startTime;
			}else {
				return 0;
			}
			
			
			
		}
		


		

	}
