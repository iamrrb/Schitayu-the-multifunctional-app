package com.rrbofficial.btrapplock;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.muddzdev.styleabletoastlibrary.StyleableToast;
import com.sdsmdg.tastytoast.TastyToast;


public class schitayuhome extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ImageView camera, faculty,aboutusimg, phone,notes,gsite,contactimg,feedbackbtn,error, flashlg,addon, gallary,
            status, esocial, thanks,developersschitayu, smsicon;
    SwitchCompat mode ;

    TextView updatetext ,share ;
    public static final int REQUEST_LOCATION = 10;
    private static final int REQUEST_PERMISSIONS = 20;
    private DrawerLayout mDrawerLayout ;
    private ActionBarDrawerToggle mToggle ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schitayuhome);

        int permission_All = 1;




        String[] Permissions = {Manifest.permission.CAMERA, Manifest.permission.CALL_PHONE,
                Manifest.permission.READ_CONTACTS, Manifest.permission.WRITE_CONTACTS,
                Manifest.permission.SEND_SMS, Manifest.permission.MEDIA_CONTENT_CONTROL,
                Manifest.permission.INTERNET,Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.SET_WALLPAPER,Manifest.permission.SET_WALLPAPER_HINTS,
                Manifest.permission.BLUETOOTH,Manifest.permission.BLUETOOTH_ADMIN,Manifest.permission.ACCESS_FINE_LOCATION
        };

        if (!hasPermissions(this, Permissions)) {

            ActivityCompat.requestPermissions(this, Permissions, permission_All);
        }
        updatetext=(TextView)findViewById(R.id.updateline);
        share=(TextView)findViewById(R.id.sharetext);
        smsicon = (ImageView) findViewById(R.id.smsimg);
        thanks = (ImageView) findViewById(R.id.thanksimg);
        camera = (ImageView) findViewById(R.id.cameraimg);
        faculty = (ImageView) findViewById(R.id.facultyimg);
        phone = (ImageView) findViewById(R.id.phonesimg);
        notes = (ImageView) findViewById(R.id.notesimg);
        flashlg = (ImageView) findViewById(R.id.flashlightimg);
        gallary = (ImageView) findViewById(R.id.gallaryimg);
        esocial = (ImageView) findViewById(R.id.esocialimg);
        contactimg = (ImageView) findViewById(R.id.contactsimg);
        status = (ImageView) findViewById(R.id.mydeviceimg);
        error = (ImageView) findViewById(R.id.errorimg);
        gsite = (ImageView) findViewById(R.id.gcoeasite);
       feedbackbtn= (ImageView) findViewById(R.id.feedbackimg);
        developersschitayu= (ImageView) findViewById(R.id.devepimg);
        aboutusimg= (ImageView) findViewById(R.id.aboutus);
        addon = (ImageView) findViewById(R.id.addonimg);


        updatetext.setSelected(true);
        ///SPEECH SECTIONS

        aboutusimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(schitayuhome.this, schitayutv.class);
                startActivity(it);
            }
        });

        feedbackbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(schitayuhome.this, feedback.class);
                startActivity(it);
            }
        });

        developersschitayu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(schitayuhome.this, developers.class);
                startActivity(it);
            }
        });

        addon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(schitayuhome.this, addon.class);
                startActivity(it);
            }
        });


        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(schitayuhome.this, phone.class);
                startActivity(it);
            }
        });

        gallary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(schitayuhome.this, gcoea_wall.class);
                startActivity(it);
            }
        });

        gsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(schitayuhome.this,gcoeasite.class);
                startActivity(it);
            }
        });

        error.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(schitayuhome.this, error.class);
                startActivity(it);
            }
        });
        flashlg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(schitayuhome.this, flashlight.class);
                startActivity(it);
            }
        });

        faculty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(schitayuhome.this, fact_act.class);
                startActivity(it);
            }
        });

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(schitayuhome.this, camera_act.class);
                startActivity(it);

            }
        });


        notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(schitayuhome.this, MainActivity.class);
                startActivity(it);
            }
        });

        esocial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(schitayuhome.this, Socialentertainment.class);
                startActivity(it);
            }
        });

        status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(schitayuhome.this, mydevice.class);
                startActivity(it);
            }
        });


        smsicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(schitayuhome.this, sms.class);
                startActivity(it);
            }
        });
        contactimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(schitayuhome.this, musciplayer.class);
                startActivity(it);
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }



    private static boolean hasPermissions(Context context, String... permissions)

    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && permissions != null) {
            for (String permission : permissions) {

                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return false;
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Really Exit ?");
            builder.setMessage("Are you sure ?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            moveTaskToBack(true);
                            android.os.Process.killProcess(android.os.Process.myPid());
                            System.exit(1);
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                            TastyToast.makeText(schitayuhome.this,"Thank You..!",TastyToast.LENGTH_LONG,TastyToast.SUCCESS);
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.schitayuhome, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.Aboutapp) {
           Intent it =new Intent(schitayuhome.this,Aboutapp.class);
           startActivity(it);
        }

        if (id == R.id.modes) {
            ShowModeDialogue();
        }


        return super.onOptionsItemSelected(item);
    }

    //DIALOG SCENE :
    private void ShowModeDialogue() {
        Dialog dialog =new Dialog(schitayuhome.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.mode_dialog);
        mode=(SwitchCompat)findViewById(R.id.modeswitch);
        mode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(schitayuhome.this,"TRUE",Toast.LENGTH_SHORT).show();
                }
            }
        });
        dialog.show();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Intent it = new Intent(schitayuhome.this, camera_act.class);
            startActivity(it);
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            Intent it = new Intent(schitayuhome.this, gcoea_wall.class);
            startActivity(it);

        } else if (id == R.id.nav_feedback) {

            feedbackbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent it = new Intent(schitayuhome.this, feedback.class);
                    startActivity(it);
                }
            });
        }
         else if (id == R.id.nav_share) {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT,share.getText().toString());
            sendIntent.setType("text/plain");
            Intent.createChooser(sendIntent,"Share us to reach out more..");
            startActivity(sendIntent);

        } else if (id == R.id.nav_Entersocial) {
            Intent it = new Intent(schitayuhome.this, Socialentertainment.class);
            startActivity(it);
        }
        else if (id == R.id.nav_notes) {

            Intent it = new Intent(schitayuhome.this, MainActivity.class);
            startActivity(it);
        }
        else if (id == R.id.nav_mydevice) {

            Intent it = new Intent(schitayuhome.this, mydevice.class);
            startActivity(it);
        }
        else if (id == R.id.nav_call) {

            Intent it = new Intent(schitayuhome.this, phone.class);
            startActivity(it);
        }

        else if (id == R.id.nav_gallery) {
            Intent it = new Intent(schitayuhome.this, gcoea_wall.class);
            startActivity(it);
        }
        else if (id == R.id.nav_faculty) {
            Intent it = new Intent(schitayuhome.this, fact_act.class);
            startActivity(it);
        }
        else if (id == R.id.nav_flashlight) {
            Intent it = new Intent(schitayuhome.this, flashlight.class);
            startActivity(it);
        }
        else if (id == R.id.nav_Entersocial) {
            Intent it = new Intent(schitayuhome.this, Socialentertainment.class);
            startActivity(it);
        }
        else if (id == R.id.nav_error) {
            Intent it = new Intent(schitayuhome.this, error.class);
            startActivity(it);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void fmike(View view) {
        Dialog dialog =new Dialog(schitayuhome.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.mike_dialog);
        Button listenmikebtn =dialog.findViewById(R.id.listenbtn);
        listenmikebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StyleableToast st =new StyleableToast(schitayuhome.this,"Simple toast",Toast.LENGTH_LONG);
                st.setBackgroundColor(Color.parseColor("#3291CC"));
                st.setTextColor(Color.WHITE);
                st.setIcon(R.drawable.ic_mic_black_24dp);
                st.spinIcon();
                st.show();
            }
        });
        dialog.show();
    }
    public void fshare(View view) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT,share.getText().toString());
        sendIntent.setType("text/plain");
        Intent.createChooser(sendIntent,"Share us to reach out more..");
        startActivity(sendIntent);
    }

    public void ftv(View view) {
    }

    public void fsocial(View view) {
        Intent it = new Intent(schitayuhome.this, Socialentertainment.class);
        startActivity(it);
    }
}
