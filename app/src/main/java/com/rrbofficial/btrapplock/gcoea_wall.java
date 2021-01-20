package com.rrbofficial.btrapplock;

import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class gcoea_wall extends AppCompatActivity  {

 private    ImageView onewall,twowall,threewall,fourwall,fivewall,sixwall,sevenwall,eightwall,ninewall,tenwall ;
 private    Button save1,wall11,share1,save2,wall12,share2,save3,wall13,share3,save4,wall14,share4,
         save5,wall15,share5,save6,wall16,share6,
         save7,wall17,share7,save8,wall18,share8,
         save9,wall19,share9,save10,wall110,share10
         ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gcoea_wall);
        onewall =(ImageView)findViewById(R.id.wallone);
        save1 =(Button)findViewById(R.id.download1);
        share1 =(Button)findViewById(R.id.share1);
        wall11 =(Button)findViewById(R.id.setwall1);

        twowall =(ImageView)findViewById(R.id.walltwo);
        save2 =(Button)findViewById(R.id.download2);
        share2 =(Button)findViewById(R.id.share2);
        wall12 =(Button)findViewById(R.id.setwall2);

        threewall =(ImageView)findViewById(R.id.wallthree);
        save3 =(Button)findViewById(R.id.download3);
        share3 =(Button)findViewById(R.id.share3);
        wall13 =(Button)findViewById(R.id.setwall3);

        fourwall =(ImageView)findViewById(R.id.wallone);
        save4 =(Button)findViewById(R.id.download4);
        share4 =(Button)findViewById(R.id.share4);
        wall14 =(Button)findViewById(R.id.setwall4);

        fivewall =(ImageView)findViewById(R.id.wallfive);
        save5=(Button)findViewById(R.id.download5);
        share5 =(Button)findViewById(R.id.share5);
        wall15 =(Button)findViewById(R.id.setwall5);

        sixwall =(ImageView)findViewById(R.id.wallsix);
        save6 =(Button)findViewById(R.id.download6);
        share6 =(Button)findViewById(R.id.share6);
        wall16 =(Button)findViewById(R.id.setwall6);

        sevenwall =(ImageView)findViewById(R.id.wallseven);
        save7 =(Button)findViewById(R.id.download7);
        share7 =(Button)findViewById(R.id.share7);
        wall17 =(Button)findViewById(R.id.setwall7);

        eightwall =(ImageView)findViewById(R.id.walleight);
        save8 =(Button)findViewById(R.id.download8);
        share8 =(Button)findViewById(R.id.share8);
        wall18 =(Button)findViewById(R.id.setwall8);

        ninewall =(ImageView)findViewById(R.id.wallnine);
        save9 =(Button)findViewById(R.id.download9);
        share9 =(Button)findViewById(R.id.share9);
        wall19 =(Button)findViewById(R.id.setwall9);

        tenwall =(ImageView)findViewById(R.id.wallten);
        save10=(Button)findViewById(R.id.download10);
        share10 =(Button)findViewById(R.id.share10);
        wall110 =(Button)findViewById(R.id.setwall10);

            //for first wall
        save1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileOutputStream fileOutputStream =null;
                File file =getDisc();
                if(!file.exists()&&!file.mkdir()){
                    Toast.makeText(gcoea_wall.this,"Can't create directory to save",Toast.LENGTH_SHORT).show();
                    return;
                }
                SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyymmsshhmmss");
                String date =simpleDateFormat.format(new Date());
                String name ="IMG"+date+".jpg";
                String file_name =file.getAbsolutePath()+"/"+name;
                File new_file =new File(file_name);
                try{
                    fileOutputStream =new FileOutputStream(new_file);
                    Bitmap bitmap=viewToBitmap(onewall,onewall.getWidth(),onewall.getHeight());
                    bitmap.compress(Bitmap.CompressFormat.JPEG,100,fileOutputStream);
                    Toast.makeText(gcoea_wall.this,"wallpaper save",Toast.LENGTH_SHORT).show();
                    fileOutputStream.flush();
                    fileOutputStream.close();
                }catch (FileNotFoundException e)
                {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                refreshGallery(new_file);
            }

            private void refreshGallery(File file) {
                Intent intent =new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                intent.setData(Uri.fromFile(file));
                sendBroadcast(intent);
            }
        });

        share1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap =viewToBitmap(onewall,onewall.getWidth(),onewall.getHeight());
                Intent shareintent =new Intent(Intent.ACTION_SEND);
                shareintent.setType("image/jpeg");
                ByteArrayOutputStream byteArrayOutputStream =new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
                File file = new File(Environment.getExternalStorageDirectory()+ File.separator+"Imagedemo.jpeg");
                try {
                    file.createNewFile();
                    FileOutputStream fileOutputStream=new FileOutputStream(file);
                    fileOutputStream.write(byteArrayOutputStream.toByteArray());
                }
                catch (IOException e){
                    e.printStackTrace();
                }
                shareintent.putExtra(Intent.EXTRA_STREAM, Uri.parse("file://sdcard//Imagedemo.jpg") );
                startActivity(Intent.createChooser(shareintent,"share image") );
            }
        });

        wall11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WallpaperManager wallpaperManager =WallpaperManager.getInstance(getApplicationContext());
                try {
                    wallpaperManager.setBitmap(viewToBitmap(onewall,onewall.getWidth(),onewall.getHeight()));
                    Toast.makeText(gcoea_wall.this,"wallpaper set successfull",Toast.LENGTH_LONG).show();

                }catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        });



            //for 2nd wall

        save2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileOutputStream fileOutputStream =null;
                File file =getDisc();
                if(!file.exists()&&!file.mkdir()){
                    Toast.makeText(gcoea_wall.this,"Can't create directory to save",Toast.LENGTH_SHORT).show();
                    return;
                }
                SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyymmsshhmmss");
                String date =simpleDateFormat.format(new Date());
                String name ="IMG"+date+".jpg";
                String file_name =file.getAbsolutePath()+"/"+name;
                File new_file =new File(file_name);
                try{
                    fileOutputStream =new FileOutputStream(new_file);
                    Bitmap bitmap=viewToBitmap(twowall,twowall.getWidth(),twowall.getHeight());
                    bitmap.compress(Bitmap.CompressFormat.JPEG,100,fileOutputStream);
                    Toast.makeText(gcoea_wall.this,"wallpaper save",Toast.LENGTH_SHORT).show();
                    fileOutputStream.flush();
                    fileOutputStream.close();
                }catch (FileNotFoundException e)
                {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                refreshGallery(new_file);
            }

            private void refreshGallery(File file) {
                Intent intent =new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                intent.setData(Uri.fromFile(file));
                sendBroadcast(intent);
            }
        });

        share2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap =viewToBitmap(twowall,twowall.getWidth(),twowall.getHeight());
                Intent shareintent =new Intent(Intent.ACTION_SEND);
                shareintent.setType("image/jpeg");
                ByteArrayOutputStream byteArrayOutputStream =new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
                File file = new File(Environment.getExternalStorageDirectory()+ File.separator+"Imagedemo.jpeg");
                try {
                    file.createNewFile();
                    FileOutputStream fileOutputStream=new FileOutputStream(file);
                    fileOutputStream.write(byteArrayOutputStream.toByteArray());
                }
                catch (IOException e){
                    e.printStackTrace();
                }
                shareintent.putExtra(Intent.EXTRA_STREAM, Uri.parse("file://sdcard//Imagedemo.jpg") );
                startActivity(Intent.createChooser(shareintent,"share image") );
            }
        });

        wall12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WallpaperManager wallpaperManager =WallpaperManager.getInstance(getApplicationContext());
                try {
                    wallpaperManager.setBitmap(viewToBitmap(twowall,twowall.getWidth(),twowall.getHeight()));
                    Toast.makeText(gcoea_wall.this,"wallpaper set successfull",Toast.LENGTH_LONG).show();

                }catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        });


            //thired one


        save3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileOutputStream fileOutputStream =null;
                File file =getDisc();
                if(!file.exists()&&!file.mkdir()){
                    Toast.makeText(gcoea_wall.this,"Can't create directory to save",Toast.LENGTH_SHORT).show();
                    return;
                }
                SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyymmsshhmmss");
                String date =simpleDateFormat.format(new Date());
                String name ="IMG"+date+".jpg";
                String file_name =file.getAbsolutePath()+"/"+name;
                File new_file =new File(file_name);
                try{
                    fileOutputStream =new FileOutputStream(new_file);
                    Bitmap bitmap=viewToBitmap(threewall,threewall.getWidth(),twowall.getHeight());
                    bitmap.compress(Bitmap.CompressFormat.JPEG,100,fileOutputStream);
                    Toast.makeText(gcoea_wall.this,"wallpaper save",Toast.LENGTH_SHORT).show();
                    fileOutputStream.flush();
                    fileOutputStream.close();
                }catch (FileNotFoundException e)
                {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                refreshGallery(new_file);
            }

            private void refreshGallery(File file) {
                Intent intent =new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                intent.setData(Uri.fromFile(file));
                sendBroadcast(intent);
            }
        });

        share3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap =viewToBitmap(threewall,threewall.getWidth(),threewall.getHeight());
                Intent shareintent =new Intent(Intent.ACTION_SEND);
                shareintent.setType("image/jpeg");
                ByteArrayOutputStream byteArrayOutputStream =new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
                File file = new File(Environment.getExternalStorageDirectory()+ File.separator+"Imagedemo.jpeg");
                try {
                    file.createNewFile();
                    FileOutputStream fileOutputStream=new FileOutputStream(file);
                    fileOutputStream.write(byteArrayOutputStream.toByteArray());
                }
                catch (IOException e){
                    e.printStackTrace();
                }
                shareintent.putExtra(Intent.EXTRA_STREAM, Uri.parse("file://sdcard//Imagedemo.jpg") );
                startActivity(Intent.createChooser(shareintent,"share image") );
            }
        });

        wall13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WallpaperManager wallpaperManager =WallpaperManager.getInstance(getApplicationContext());
                try {
                    wallpaperManager.setBitmap(viewToBitmap(threewall,threewall.getWidth(),threewall.getHeight()));
                    Toast.makeText(gcoea_wall.this,"wallpaper set successfull",Toast.LENGTH_LONG).show();

                }catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        });


        //four

        save4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileOutputStream fileOutputStream =null;
                File file =getDisc();
                if(!file.exists()&&!file.mkdir()){
                    Toast.makeText(gcoea_wall.this,"Can't create directory to save",Toast.LENGTH_SHORT).show();
                    return;
                }
                SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyymmsshhmmss");
                String date =simpleDateFormat.format(new Date());
                String name ="IMG"+date+".jpg";
                String file_name =file.getAbsolutePath()+"/"+name;
                File new_file =new File(file_name);
                try{
                    fileOutputStream =new FileOutputStream(new_file);
                    Bitmap bitmap=viewToBitmap(fourwall,fourwall.getWidth(),twowall.getHeight());
                    bitmap.compress(Bitmap.CompressFormat.JPEG,100,fileOutputStream);
                    Toast.makeText(gcoea_wall.this,"wallpaper save",Toast.LENGTH_SHORT).show();
                    fileOutputStream.flush();
                    fileOutputStream.close();
                }catch (FileNotFoundException e)
                {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                refreshGallery(new_file);
            }

            private void refreshGallery(File file) {
                Intent intent =new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                intent.setData(Uri.fromFile(file));
                sendBroadcast(intent);
            }
        });

        share4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap =viewToBitmap(fourwall,fourwall.getWidth(),fourwall.getHeight());
                Intent shareintent =new Intent(Intent.ACTION_SEND);
                shareintent.setType("image/jpeg");
                ByteArrayOutputStream byteArrayOutputStream =new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
                File file = new File(Environment.getExternalStorageDirectory()+ File.separator+"Imagedemo.jpeg");
                try {
                    file.createNewFile();
                    FileOutputStream fileOutputStream=new FileOutputStream(file);
                    fileOutputStream.write(byteArrayOutputStream.toByteArray());
                }
                catch (IOException e){
                    e.printStackTrace();
                }
                shareintent.putExtra(Intent.EXTRA_STREAM, Uri.parse("file://sdcard//Imagedemo.jpg") );
                startActivity(Intent.createChooser(shareintent,"share image") );
            }
        });

        wall14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WallpaperManager wallpaperManager =WallpaperManager.getInstance(getApplicationContext());
                try {
                    wallpaperManager.setBitmap(viewToBitmap(fourwall,fourwall.getWidth(),fourwall.getHeight()));
                    Toast.makeText(gcoea_wall.this,"wallpaper set successfull",Toast.LENGTH_LONG).show();

                }catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        });


        //five

        save5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileOutputStream fileOutputStream =null;
                File file =getDisc();
                if(!file.exists()&&!file.mkdir()){
                    Toast.makeText(gcoea_wall.this,"Can't create directory to save",Toast.LENGTH_SHORT).show();
                    return;
                }
                SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyymmsshhmmss");
                String date =simpleDateFormat.format(new Date());
                String name ="IMG"+date+".jpg";
                String file_name =file.getAbsolutePath()+"/"+name;
                File new_file =new File(file_name);
                try{
                    fileOutputStream =new FileOutputStream(new_file);
                    Bitmap bitmap=viewToBitmap(fivewall,fivewall.getWidth(),fivewall.getHeight());
                    bitmap.compress(Bitmap.CompressFormat.JPEG,100,fileOutputStream);
                    Toast.makeText(gcoea_wall.this,"wallpaper save",Toast.LENGTH_SHORT).show();
                    fileOutputStream.flush();
                    fileOutputStream.close();
                }catch (FileNotFoundException e)
                {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                refreshGallery(new_file);
            }

            private void refreshGallery(File file) {
                Intent intent =new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                intent.setData(Uri.fromFile(file));
                sendBroadcast(intent);
            }
        });

        share5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap =viewToBitmap(fivewall,fivewall.getWidth(),fivewall.getHeight());
                Intent shareintent =new Intent(Intent.ACTION_SEND);
                shareintent.setType("image/jpeg");
                ByteArrayOutputStream byteArrayOutputStream =new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
                File file = new File(Environment.getExternalStorageDirectory()+ File.separator+"Imagedemo.jpeg");
                try {
                    file.createNewFile();
                    FileOutputStream fileOutputStream=new FileOutputStream(file);
                    fileOutputStream.write(byteArrayOutputStream.toByteArray());
                }
                catch (IOException e){
                    e.printStackTrace();
                }
                shareintent.putExtra(Intent.EXTRA_STREAM, Uri.parse("file://sdcard//Imagedemo.jpg") );
                startActivity(Intent.createChooser(shareintent,"share image") );
            }
        });

        wall15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WallpaperManager wallpaperManager =WallpaperManager.getInstance(getApplicationContext());
                try {
                    wallpaperManager.setBitmap(viewToBitmap(fivewall,fivewall.getWidth(),fivewall.getHeight()));
                    Toast.makeText(gcoea_wall.this,"wallpaper set successfull",Toast.LENGTH_LONG).show();

                }catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        });


        //six


        save6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileOutputStream fileOutputStream =null;
                File file =getDisc();
                if(!file.exists()&&!file.mkdir()){
                    Toast.makeText(gcoea_wall.this,"Can't create directory to save",Toast.LENGTH_SHORT).show();
                    return;
                }
                SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyymmsshhmmss");
                String date =simpleDateFormat.format(new Date());
                String name ="IMG"+date+".jpg";
                String file_name =file.getAbsolutePath()+"/"+name;
                File new_file =new File(file_name);
                try{
                    fileOutputStream =new FileOutputStream(new_file);
                    Bitmap bitmap=viewToBitmap(sixwall,sixwall.getWidth(),sixwall.getHeight());
                    bitmap.compress(Bitmap.CompressFormat.JPEG,100,fileOutputStream);
                    Toast.makeText(gcoea_wall.this,"wallpaper save",Toast.LENGTH_SHORT).show();
                    fileOutputStream.flush();
                    fileOutputStream.close();
                }catch (FileNotFoundException e)
                {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                refreshGallery(new_file);
            }

            private void refreshGallery(File file) {
                Intent intent =new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                intent.setData(Uri.fromFile(file));
                sendBroadcast(intent);
            }
        });

        share6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap =viewToBitmap(sixwall,sixwall.getWidth(),sixwall.getHeight());
                Intent shareintent =new Intent(Intent.ACTION_SEND);
                shareintent.setType("image/jpeg");
                ByteArrayOutputStream byteArrayOutputStream =new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
                File file = new File(Environment.getExternalStorageDirectory()+ File.separator+"Imagedemo.jpeg");
                try {
                    file.createNewFile();
                    FileOutputStream fileOutputStream=new FileOutputStream(file);
                    fileOutputStream.write(byteArrayOutputStream.toByteArray());
                }
                catch (IOException e){
                    e.printStackTrace();
                }
                shareintent.putExtra(Intent.EXTRA_STREAM, Uri.parse("file://sdcard//Imagedemo.jpg") );
                startActivity(Intent.createChooser(shareintent,"share image") );
            }
        });

        wall16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WallpaperManager wallpaperManager =WallpaperManager.getInstance(getApplicationContext());
                try {
                    wallpaperManager.setBitmap(viewToBitmap(sixwall,sixwall.getWidth(),sixwall.getHeight()));
                    Toast.makeText(gcoea_wall.this,"wallpaper set successfull",Toast.LENGTH_LONG).show();

                }catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        });


        save7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileOutputStream fileOutputStream =null;
                File file =getDisc();
                if(!file.exists()&&!file.mkdir()){
                    Toast.makeText(gcoea_wall.this,"Can't create directory to save",Toast.LENGTH_SHORT).show();
                    return;
                }
                SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyymmsshhmmss");
                String date =simpleDateFormat.format(new Date());
                String name ="IMG"+date+".jpg";
                String file_name =file.getAbsolutePath()+"/"+name;
                File new_file =new File(file_name);
                try{
                    fileOutputStream =new FileOutputStream(new_file);
                    Bitmap bitmap=viewToBitmap(sevenwall,sevenwall.getWidth(),sevenwall.getHeight());
                    bitmap.compress(Bitmap.CompressFormat.JPEG,100,fileOutputStream);
                    Toast.makeText(gcoea_wall.this,"wallpaper save",Toast.LENGTH_SHORT).show();
                    fileOutputStream.flush();
                    fileOutputStream.close();
                }catch (FileNotFoundException e)
                {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                refreshGallery(new_file);
            }

            private void refreshGallery(File file) {
                Intent intent =new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                intent.setData(Uri.fromFile(file));
                sendBroadcast(intent);
            }
        });

        share7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap =viewToBitmap(sevenwall,sevenwall.getWidth(),sevenwall.getHeight());
                Intent shareintent =new Intent(Intent.ACTION_SEND);
                shareintent.setType("image/jpeg");
                ByteArrayOutputStream byteArrayOutputStream =new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
                File file = new File(Environment.getExternalStorageDirectory()+ File.separator+"Imagedemo.jpeg");
                try {
                    file.createNewFile();
                    FileOutputStream fileOutputStream=new FileOutputStream(file);
                    fileOutputStream.write(byteArrayOutputStream.toByteArray());
                }
                catch (IOException e){
                    e.printStackTrace();
                }
                shareintent.putExtra(Intent.EXTRA_STREAM, Uri.parse("file://sdcard//Imagedemo.jpg") );
                startActivity(Intent.createChooser(shareintent,"share image") );
            }
        });

        wall17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WallpaperManager wallpaperManager =WallpaperManager.getInstance(getApplicationContext());
                try {
                    wallpaperManager.setBitmap(viewToBitmap(sevenwall,sevenwall.getWidth(),sevenwall.getHeight()));
                    Toast.makeText(gcoea_wall.this,"wallpaper set successfull",Toast.LENGTH_LONG).show();

                }catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        });



        //EIGHT
        save8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileOutputStream fileOutputStream =null;
                File file =getDisc();
                if(!file.exists()&&!file.mkdir()){
                    Toast.makeText(gcoea_wall.this,"Can't create directory to save",Toast.LENGTH_SHORT).show();
                    return;
                }
                SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyymmsshhmmss");
                String date =simpleDateFormat.format(new Date());
                String name ="IMG"+date+".jpg";
                String file_name =file.getAbsolutePath()+"/"+name;
                File new_file =new File(file_name);
                try{
                    fileOutputStream =new FileOutputStream(new_file);
                    Bitmap bitmap=viewToBitmap(eightwall,eightwall.getWidth(),eightwall.getHeight());
                    bitmap.compress(Bitmap.CompressFormat.JPEG,100,fileOutputStream);
                    Toast.makeText(gcoea_wall.this,"wallpaper save",Toast.LENGTH_SHORT).show();
                    fileOutputStream.flush();
                    fileOutputStream.close();
                }catch (FileNotFoundException e)
                {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                refreshGallery(new_file);
            }

            private void refreshGallery(File file) {
                Intent intent =new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                intent.setData(Uri.fromFile(file));
                sendBroadcast(intent);
            }
        });


        share8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap =viewToBitmap(eightwall,eightwall.getWidth(),eightwall.getHeight());
                Intent shareintent =new Intent(Intent.ACTION_SEND);
                shareintent.setType("image/jpeg");
                ByteArrayOutputStream byteArrayOutputStream =new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
                File file = new File(Environment.getExternalStorageDirectory()+ File.separator+"Imagedemo.jpeg");
                try {
                    file.createNewFile();
                    FileOutputStream fileOutputStream=new FileOutputStream(file);
                    fileOutputStream.write(byteArrayOutputStream.toByteArray());
                }
                catch (IOException e){
                    e.printStackTrace();
                }
                shareintent.putExtra(Intent.EXTRA_STREAM, Uri.parse("file://sdcard//Imagedemo.jpg") );
                startActivity(Intent.createChooser(shareintent,"share image") );
            }
        });

        wall18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WallpaperManager wallpaperManager =WallpaperManager.getInstance(getApplicationContext());
                try {
                    wallpaperManager.setBitmap(viewToBitmap(eightwall,eightwall.getWidth(),eightwall.getHeight()));
                    Toast.makeText(gcoea_wall.this,"wallpaper set successfull",Toast.LENGTH_LONG).show();

                }catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        });


            //nine

        save8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileOutputStream fileOutputStream =null;
                File file =getDisc();
                if(!file.exists()&&!file.mkdir()){
                    Toast.makeText(gcoea_wall.this,"Can't create directory to save",Toast.LENGTH_SHORT).show();
                    return;
                }
                SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyymmsshhmmss");
                String date =simpleDateFormat.format(new Date());
                String name ="IMG"+date+".jpg";
                String file_name =file.getAbsolutePath()+"/"+name;
                File new_file =new File(file_name);
                try{
                    fileOutputStream =new FileOutputStream(new_file);
                    Bitmap bitmap=viewToBitmap(eightwall,eightwall.getWidth(),eightwall.getHeight());
                    bitmap.compress(Bitmap.CompressFormat.JPEG,100,fileOutputStream);
                    Toast.makeText(gcoea_wall.this,"wallpaper save",Toast.LENGTH_SHORT).show();
                    fileOutputStream.flush();
                    fileOutputStream.close();
                }catch (FileNotFoundException e)
                {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                refreshGallery(new_file);
            }

            private void refreshGallery(File file) {
                Intent intent =new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                intent.setData(Uri.fromFile(file));
                sendBroadcast(intent);
            }
        });


        share9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap =viewToBitmap(ninewall,ninewall.getWidth(),ninewall.getHeight());
                Intent shareintent =new Intent(Intent.ACTION_SEND);
                shareintent.setType("image/jpeg");
                ByteArrayOutputStream byteArrayOutputStream =new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
                File file = new File(Environment.getExternalStorageDirectory()+ File.separator+"Imagedemo.jpeg");
                try {
                    file.createNewFile();
                    FileOutputStream fileOutputStream=new FileOutputStream(file);
                    fileOutputStream.write(byteArrayOutputStream.toByteArray());
                }
                catch (IOException e){
                    e.printStackTrace();
                }
                shareintent.putExtra(Intent.EXTRA_STREAM, Uri.parse("file://sdcard//Imagedemo.jpg") );
                startActivity(Intent.createChooser(shareintent,"share image") );
            }
        });

        wall19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WallpaperManager wallpaperManager =WallpaperManager.getInstance(getApplicationContext());
                try {
                    wallpaperManager.setBitmap(viewToBitmap(ninewall,ninewall.getWidth(),ninewall.getHeight()));
                    Toast.makeText(gcoea_wall.this,"wallpaper set successfull",Toast.LENGTH_LONG).show();

                }catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        });


            //ten

        save10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileOutputStream fileOutputStream =null;
                File file =getDisc();
                if(!file.exists()&&!file.mkdir()){
                    Toast.makeText(gcoea_wall.this,"Can't create directory to save",Toast.LENGTH_SHORT).show();
                    return;
                }
                SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyymmsshhmmss");
                String date =simpleDateFormat.format(new Date());
                String name ="IMG"+date+".jpg";
                String file_name =file.getAbsolutePath()+"/"+name;
                File new_file =new File(file_name);
                try{
                    fileOutputStream =new FileOutputStream(new_file);
                    Bitmap bitmap=viewToBitmap(tenwall,tenwall.getWidth(),tenwall.getHeight());
                    bitmap.compress(Bitmap.CompressFormat.JPEG,100,fileOutputStream);
                    Toast.makeText(gcoea_wall.this,"wallpaper save",Toast.LENGTH_SHORT).show();
                    fileOutputStream.flush();
                    fileOutputStream.close();
                }catch (FileNotFoundException e)
                {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                refreshGallery(new_file);
            }

            private void refreshGallery(File file) {
                Intent intent =new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                intent.setData(Uri.fromFile(file));
                sendBroadcast(intent);
            }
        });


        share10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap =viewToBitmap(tenwall,tenwall.getWidth(),tenwall.getHeight());
                Intent shareintent =new Intent(Intent.ACTION_SEND);
                shareintent.setType("image/jpeg");
                ByteArrayOutputStream byteArrayOutputStream =new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
                File file = new File(Environment.getExternalStorageDirectory()+ File.separator+"Imagedemo.jpeg");
                try {
                    file.createNewFile();
                    FileOutputStream fileOutputStream=new FileOutputStream(file);
                    fileOutputStream.write(byteArrayOutputStream.toByteArray());
                }
                catch (IOException e){
                    e.printStackTrace();
                }
                shareintent.putExtra(Intent.EXTRA_STREAM, Uri.parse("file://sdcard//Imagedemo.jpg") );
                startActivity(Intent.createChooser(shareintent,"share image") );
            }
        });

        wall110.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WallpaperManager wallpaperManager =WallpaperManager.getInstance(getApplicationContext());
                try {
                    wallpaperManager.setBitmap(viewToBitmap(tenwall,tenwall.getWidth(),tenwall.getHeight()));
                    Toast.makeText(gcoea_wall.this,"wallpaper set successfull",Toast.LENGTH_LONG).show();

                }catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        });


    }
    public  static Bitmap viewToBitmap(View view,int width,int height){
        Bitmap bitmap=Bitmap.createBitmap(width,height,Bitmap.Config.ARGB_8888);
        Canvas canvas =new Canvas(bitmap);
        view.draw(canvas);
        return bitmap;
    }
    private void refreshGallery(File file) {
        Intent intent =new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        intent.setData(Uri.fromFile(file));
        sendBroadcast(intent);
    }
    private  File getDisc()
    {
        File file =Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        return  new File(file,"Image Demo");
    }

}
