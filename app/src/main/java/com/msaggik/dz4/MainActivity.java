package com.msaggik.dz4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private String pi = "3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679" +
            "8214808651328230664709384460955058223172535940812848111745028410270193852110555964462294895493038196" +
            "4428810975665933446128475648233786783165271201909145648566923460348610454326648213393607260249141273" +
            "7245870066063155881748815209209628292540917153643678925903600113305305488204665213841469519415116094" +
            "36575959195309218611738193261179310511854807446237996274956735188575272489122793818301194912";

    private int[] arrayInt;
    private int count3;
    private int count5;
    private int rareDigit;
    private int[] reversArrayInt;
    private int[] sortArrayInt;
    private TextView infoApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayInt = arrayInt(pi);
        count3 = countDigit(arrayInt, 3);
        count5 = countDigit(arrayInt, 5);
        rareDigit = rareDigit(arrayInt);
        reversArrayInt = reversArrayInt(arrayInt);

        sortArrayInt = Arrays.copyOf(arrayInt, arrayInt.length);
        Arrays.sort(sortArrayInt);

        infoApp = findViewById(R.id.infoApp);
        infoApp.setText("Массив из числа π: " + Arrays.toString(arrayInt) + "\n" +
                "Количество цифр 3: " + count3 + "\n" +
                "Количество цифр 5: " + count5 + "\n" +
                "Самая редкая цифра: " + rareDigit + "\n" +
                "Массив задом наперёд: " + Arrays.toString(reversArrayInt) + "\n" +
                "Отсортированный массив: " + Arrays.toString(sortArrayInt));
    }

    private int[] reversArrayInt(int[] arrayDigit) {
        int[] revers = new int[arrayDigit.length];
        for (int i = arrayDigit.length - 1; i >= 0; i--) {
            revers[arrayDigit.length - (i + 1)] = arrayDigit[i];
        }
        return revers;
    }

    private int countDigit(int[] arrayDigit, int digit) {
        int count = 0;
        for (int i : arrayDigit) {
            if (i == digit) {
                count++;
            }
        }
        return count;
    }

    private int rareDigit(int[] arrayDigit) {
        int[] count = new int[10];
        for (int i : arrayDigit) {
            count[i]++;
        }
        int rare = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] < count[rare]) {
                rare = i;
            }
        }
        return rare;
    }

    private int[] arrayInt(String string) {
        String stringNew = string.replace(".", "");
        String[] arrayString = stringNew.split("");
        int[] arrayInteger = new int[arrayString.length];
        for (int i = 0; i < arrayString.length; i++) {
            arrayInteger[i] = Integer.parseInt(arrayString[i]);
        }
        return arrayInteger;
    }
}
