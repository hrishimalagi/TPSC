import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    static String[] words={"hi","hello","envelope","hrishikesh","sarvesh","passport"};

    public static void main(String[] args) throws InterruptedException{

        System.out.println("3");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("2");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("1");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Instruction :- You need to enter the sentence shown on the screen and compulsorily add a space to the end ");
        StringBuilder randomizedString = new StringBuilder();
        Random arr=new Random();
        for (int i=0;i<5;i++){
            String wordToPrint = words[arr.nextInt(4)]+ " ";
            System.out.print(wordToPrint);// change
            randomizedString.append(wordToPrint);
        }
        System.out.println();
        double begin= LocalTime.now().toNanoOfDay();

        Scanner scann=new Scanner(System.in);
        String typeWords = scann.nextLine();

        double stop=LocalTime.now().toNanoOfDay();
        double elapsedTime=stop-begin;
        double seconds=elapsedTime/1000000000.0;

        int chars=typeWords.length();

        int wpm = (int) ((((double)chars/5)/seconds)*60);
        System.out.println("YOur WPM is " +wpm+ "!");

        int totalCharacters = 0;
        int errorCount = 0;
        if(typeWords.length() < randomizedString.length()){
            errorCount += (randomizedString.length() - typeWords.length());
            totalCharacters = typeWords.length();
        }
        else{
            totalCharacters = randomizedString.length();
        }

        for (int i=0;i<totalCharacters;i++)
        {
            if(randomizedString.charAt(i) != typeWords.charAt(i)){
                errorCount++;
            }
        }


      double errorPercentage = (errorCount*1.0/totalCharacters)*100;
       double finaleErrorP = Math.round(errorPercentage*100)/100.0;
        System.out.println("Error  is "+Double.toString(finaleErrorP)+"%");
        double accuracy = totalCharacters-errorCount;
        double accuracyP= (accuracy*1.0/totalCharacters)*100;
         accuracyP = Math.round(accuracyP*100)/100.0;
        System.out.println("your accuracy is " + accuracyP + "%" );

     }

}

