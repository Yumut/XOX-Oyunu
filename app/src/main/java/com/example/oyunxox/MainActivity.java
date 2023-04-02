package com.example.oyunxox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.oyunxox.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    private final List<int[]> list = new ArrayList<>();
    private int oyuncutur = 1;
    private int[]pozisyon={0,0,0,0,0,0,0,0,0};
    private int toplamsecili= 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        list.add(new int[] {0,1,2});
        list.add(new int[] {3,4,5});
        list.add(new int[] {6,7,8});
        list.add(new int[] {0,3,6});
        list.add(new int[] {1,4,7});
        list.add(new int[] {2,5,8});
        list.add(new int[] {2,4,6});
        list.add(new int[] {0,4,8});

        binding.image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (secim(0)){
                    performAction((ImageView) view, 0);
                }
            }
        });


        binding.image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (secim(1)){
                    performAction((ImageView) view, 1);
                }
            }
        });
        binding.image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (secim(2)){
                    performAction((ImageView) view, 2);
                }
            }
        });
        binding.image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (secim(3)){
                    performAction((ImageView) view, 3);
                }
            }
        });
        binding.image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (secim(4)){
                    performAction((ImageView) view, 4);
                }
            }
        });
        binding.image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (secim(5)){
                    performAction((ImageView) view, 5);
                }
            }
        });
        binding.image7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (secim(6)){
                    performAction((ImageView) view, 6);
                }
            }
        });
        binding.image8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (secim(7)){
                    performAction((ImageView) view, 7);
                }
            }
        });
        binding.image9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (secim(8)){
                    performAction((ImageView) view, 8);
                }
            }
        });
    }

    private void OyuncuTurDegis(int mevcutoyuncu) {

        oyuncutur = mevcutoyuncu;
        if (oyuncutur == 1) {
            binding.oyuncu1layout.setBackgroundResource(R.drawable.sc);
            binding.Oyuncu2Layout.setBackgroundResource(R.drawable.bkutu);

        } else {

            binding.oyuncu1layout.setBackgroundResource(R.drawable.bkutu);
            binding.Oyuncu2Layout.setBackgroundResource(R.drawable.sc);
        }
    }
    private void performAction(ImageView imageView,int selectedBoxPosition){
        pozisyon[selectedBoxPosition]= oyuncutur;

        if (oyuncutur == 1) {
            imageView.setImageResource(R.drawable.x);
            if (SonucKontrol()) {
                sekran resultDialog = new sekran(MainActivity.this, "Kazanan : "
                        + " Oyuncu 1!", MainActivity.this);

                resultDialog.setCancelable(false);
                resultDialog.show();
            } else if(toplamsecili == 9) {
                sekran resultDialog = new sekran(MainActivity.this, "Berabare", MainActivity.this);
                resultDialog.setCancelable(false);
                resultDialog.show();
            } else {
                OyuncuTurDegis(2);
                toplamsecili++;
            }
        } else {
            imageView.setImageResource(R.drawable.o);
            if (SonucKontrol()) {
                sekran resultDialog = new sekran(MainActivity.this, "Kazanan : "
                        + " Oyuncu 2!", MainActivity.this);
                resultDialog.setCancelable(false);
                resultDialog.show();
            } else if(toplamsecili == 9) {
                sekran resultDialog = new sekran(MainActivity.this, "Berabere", MainActivity.this);
                resultDialog.setCancelable(false);
                resultDialog.show();
            } else {
                OyuncuTurDegis(1);
                toplamsecili++;
            }
        }
    }




    private boolean secim(int konum) {
        boolean response = false;
        if (pozisyon[konum] == 0) {
            response = true;
        }
        return response;
    }

    private boolean SonucKontrol(){
        boolean sonuc = false;
        for (int i = 0; i < list.size(); i++){
            final int[] combination = list.get(i);

            if (pozisyon[combination[0]] == oyuncutur&& pozisyon[combination[1]] == oyuncutur &&
                    pozisyon[combination[2]] == oyuncutur) {
                sonuc = true;
            }
        }
        return sonuc;
    }



    public void YenidenOyna(){
        pozisyon = new int[] {0,0,0,0,0,0,0,0,0};
        oyuncutur = 1;
        toplamsecili = 1;

        binding.image1.setImageResource(R.drawable.bkutu);
        binding.image2.setImageResource(R.drawable.bkutu);
        binding.image3.setImageResource(R.drawable.bkutu);
        binding.image4.setImageResource(R.drawable.bkutu);
        binding.image5.setImageResource(R.drawable.bkutu);
        binding.image6.setImageResource(R.drawable.bkutu);
        binding.image7.setImageResource(R.drawable.bkutu);
        binding.image8.setImageResource(R.drawable.bkutu);
        binding.image9.setImageResource(R.drawable.bkutu);


    }
}