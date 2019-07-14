package com.example.tanush.registrationmodule;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    boolean a = false, b = false, c = false, d = false, e = false;
    EditText par1, par2, vol, mail, contact, collegeName;
    int amount = 0;
    String am,am1;
    CheckBox fe, se, te, be;
    CheckBox bugOffI, bugOffT, justCodingI, justCodingT, reCodeItI, reCodeItT, codeBuddy, dataQuest, webAppDev, electroQuest, dextrous, photoShopRoyale, quiz2Bid, insight, cerebroI, cerebroT, GOTI, GOTT, friendsI, friendsT, HPI, HPT, marvelI, marvelT, DCI, DCT;
    // CheckBox codebuddy,dataquest,webappdev,electroquest,dextrous,photoshoproyale,quiz2bid,insight,got,harrypotter,friends,marveldc;
    Button submit;
    TextView fcost;
    ImageView cash, paytm;


    private FirebaseFirestore db;
    private DocumentReference documentReference;
    private CollectionReference collectionReference;
    private CollectionReference crbugOff;
    private CollectionReference crcodeBuddy;
    private CollectionReference crrecodeIt;
    private CollectionReference crjustCoding;
    private CollectionReference crelectroQuest;
    private CollectionReference crdataQuest;
    private CollectionReference crwebAppDev;
    private CollectionReference crquiz2Bid;
    private CollectionReference crDextrous;
    private CollectionReference crCerebro;
    private CollectionReference crharryPotter;
    private CollectionReference crphotoShopRoyale;
    private CollectionReference crInsight;
    private CollectionReference crGOT;
    private CollectionReference crFriends;
    private CollectionReference crMarvelvsDC;
    private CollectionReference crDC;

    private Button verify;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES)
            setTheme(R.style.DarkTheme);
        else setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        cash = findViewById(R.id.cash2Image);
        //paytm=findViewById(R.id.paytmImage);


        FirebaseApp.initializeApp(MainActivity.this);
        db = FirebaseFirestore.getInstance();
        par1 = findViewById(R.id.participant1);
        par2 = findViewById(R.id.participant2);
        vol = findViewById(R.id.volunteer);
        mail = findViewById(R.id.email);
        contact = findViewById(R.id.contact);
        collegeName = findViewById(R.id.college);







        fcost = findViewById(R.id.amount);

        // documentReference=db.collection("TempData").document("Temp1");
        collectionReference = db.collection("Combined");
        crbugOff = db.collection("BugOff");
        crcodeBuddy = db.collection("Code Buddy");
        crjustCoding = db.collection("JustCoding");
        crrecodeIt = db.collection("Recode It!");
        crdataQuest = db.collection("DataQuest");
        crelectroQuest = db.collection("ElectroQuest");
        crwebAppDev = db.collection("Web & App Development");
        crDextrous = db.collection("Dextrous");
        crCerebro = db.collection("Cerebro");
        crphotoShopRoyale = db.collection("Photoshop Royale");
        crbugOff = db.collection("BugOff");
        crquiz2Bid = db.collection("Quiz2Bid");
        crInsight = db.collection("Insight");
        crGOT = db.collection("GOT");
        crharryPotter = db.collection("Harry Potter");
        crFriends = db.collection("Friends");
        crMarvelvsDC = db.collection("Marvel");
        crDC = db.collection("DC");


        fe = findViewById(R.id.fe);
        se = findViewById(R.id.se);
        te = findViewById(R.id.te);
        be = findViewById(R.id.be);
        bugOffI = findViewById(R.id.bi);
        bugOffT = findViewById(R.id.bt);
        justCodingI = findViewById(R.id.jci);
        justCodingT = findViewById(R.id.jct);
        reCodeItI = findViewById(R.id.rii);
        reCodeItT = findViewById(R.id.rit);
        codeBuddy = findViewById(R.id.codeBuddy);
        dataQuest = findViewById(R.id.dataQuest);
        webAppDev = findViewById(R.id.webAppDev);
        electroQuest = findViewById(R.id.electroQuest);
        dextrous = findViewById(R.id.dextrous);
        photoShopRoyale = findViewById(R.id.photoShopRoyale);
        quiz2Bid = findViewById(R.id.quiz2Bid);
        insight = findViewById(R.id.insight);
        cerebroI = findViewById(R.id.cerebroInd);
        cerebroT = findViewById(R.id.cerebroTeam);
        GOTI = findViewById(R.id.GOTi);
        GOTT = findViewById(R.id.GOTteam);
        friendsI = findViewById(R.id.friendsi);
        friendsT = findViewById(R.id.friendsTeam);
        HPI = findViewById(R.id.HPi);
        HPT = findViewById(R.id.HPt);
        marvelI = findViewById(R.id.marveli);
        marvelT = findViewById(R.id.marvelTeam);
        DCI = findViewById(R.id.DCi);
        DCT = findViewById(R.id.DCt);


        cash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!funvol()) {
                    Toast.makeText(MainActivity.this, "Volunteer", Toast.LENGTH_SHORT).show();
                    vol.setError("Mandatory");
                }else if (!funpar1()) {
                    Toast.makeText(MainActivity.this, "participant", Toast.LENGTH_SHORT).show();
                    par1.setError("Mandatory");
                } else if (!funmail()) {
                    Toast.makeText(MainActivity.this, "Email", Toast.LENGTH_SHORT).show();
                    mail.setError("Mandatory");
                } else if (!funcon()) {
                    Toast.makeText(MainActivity.this, "Contact", Toast.LENGTH_SHORT).show();
                    contact.setError("Mandatory");
                } else if (!funcol()) {
                    Toast.makeText(MainActivity.this, "College", Toast.LENGTH_SHORT).show();
                    collegeName.setError("Mandatory");
                } else {


                    final AlertDialog.Builder mAlertDialog = new AlertDialog.Builder(MainActivity.this);
                    final View mView = getLayoutInflater().inflate(R.layout.activity_password_payment_cash, null);


                    mAlertDialog.setView(mView);
                    Button verify = mView.findViewById(R.id.verify);
                    final EditText password = mView.findViewById(R.id.etPassword);
                    TextView textView = mView.findViewById(R.id.textView);
                    String temp = String.valueOf(amount);
                    textView.setText("To pay:- " + amount);
                    //               textView.setText("To Pay:- "+amount);
                    final AlertDialog dialog = mAlertDialog.create();
                    dialog.show();
                    verify.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v1) {

                            if (password.getText().toString().equals("PASC")) {
                                //Toast.makeText(MainActivity.this, "User Registered into Database Successfully", Toast.LENGTH_SHORT).show();
                                final String participant1 = par1.getText().toString();
                                final String participant2 = par2.getText().toString();
                                final String volunteer = vol.getText().toString();
                                final String email = mail.getText().toString();
                                final String contactno = contact.getText().toString();
                                final String college = collegeName.getText().toString();


                                String event = "";
                                int amount = 0;
                                String rnd = getSaltString();

                                int fes = 0, ses = 0, tes = 0, bes = 0, bugi = 0, bugt = 0, jci = 0, jct = 0, rii = 0, rit = 0, cb = 0, dq = 0, wad = 0, eq = 0, dt = 0, pr = 0, q2b = 0, inst = 0, cbi = 0, cbt = 0, goti = 0, gott = 0, friendsi = 0, friendst = 0, hpi = 0, hpt = 0, marveli = 0, marvelt = 0, dci = 0, dct = 0;
                                if (fe.isChecked()) fes = 1;
                                if (se.isChecked()) ses = 1;
                                if (te.isChecked()) tes = 1;
                                if (be.isChecked()) bes = 1;


                                if (bugOffI.isChecked()) {
                                    bugi = 1;
                                    //  amount+=80;
                                    event += "BugOff(Individual), ";
                                    fcost.setText(String.valueOf(amount));

                                }
                                if (bugOffT.isChecked()) {
                                    bugt = 1;
                                    //amount+=100;
                                    event += "BugOff(Team), ";
                                    fcost.setText(String.valueOf(amount));
                                }
                                if (justCodingI.isChecked()) {
                                    jci = 1;
                                    //amount+=80;
                                    event += "JustCoding(Individual), ";
                                    fcost.setText(String.valueOf(amount));
                                }
                                if (justCodingT.isChecked()) {
                                    jct = 1;
                                    //amount+=100;
                                    event += "JustCoding(Team), ";
                                    fcost.setText(String.valueOf(amount));
                                }
                                if (reCodeItI.isChecked()) {
                                    rii = 1;
                                    //amount+=80;
                                    event += "ReCode It!(Individual), ";
                                    fcost.setText(String.valueOf(amount));

                                }
                                if (reCodeItT.isChecked()) {
                                    rit = 1;
                                    //amount+=100;
                                    event += "ReCode It!(Team), ";
                                    fcost.setText(String.valueOf(amount));

                                }
                                if (codeBuddy.isChecked()) {
                                    cb = 1;
                                    //amount+=100;
                                    event += "CodeBuddy(Team), ";
                                    fcost.setText(String.valueOf(amount));

                                }
                                if (dataQuest.isChecked()) {
                                    dq = 1;
                                    //amount+=150;
                                    event += "DataQuest, ";
                                    fcost.setText(String.valueOf(amount));

                                }
                                if (webAppDev.isChecked()) {
                                    wad = 1;
                                    //amount+=100;
                                    event += "Web-App Development, ";
                                    fcost.setText(String.valueOf(amount));

                                }
                                if (electroQuest.isChecked()) {
                                    eq = 1;
                                    //amount+=100;
                                    event += "ElectroQuest, ";
                                    fcost.setText(String.valueOf(amount));

                                }
                                if (dextrous.isChecked()) {
                                    dt = 1;
                                    //amount+=100;
                                    event += "Dextrous, ";
                                    fcost.setText(String.valueOf(amount));

                                }
                                if (photoShopRoyale.isChecked()) {
                                    pr = 1;
                                    //amount+=50;
                                    event += "Photoshop Royale, ";
                                    fcost.setText(String.valueOf(amount));

                                }
                                if (quiz2Bid.isChecked()) {
                                    q2b = 1;
                                    //amount+=100;
                                    event += "Quiz2Bid, ";
                                    fcost.setText(String.valueOf(amount));

                                }
                                if (insight.isChecked()) {
                                    inst = 1;
                                    //amount+=50;
                                    event += "Insight, ";
                                    fcost.setText(String.valueOf(amount));

                                }
                                if (cerebroI.isChecked()) {
                                    cbi = 1;
                                    //amount+=80;
                                    event += "Cerebro(Individual), ";
                                    fcost.setText(String.valueOf(amount));

                                }
                                if (cerebroT.isChecked()) {
                                    cbt = 1;
                                    //amount+=100;
                                    event += "Cerebro(Team), ";
                                    fcost.setText(String.valueOf(amount));

                                }
                                if (GOTI.isChecked()) {
                                    goti = 1;
                                    //amount+=80;
                                    event += "GOT(Individual), ";
                                    fcost.setText(String.valueOf(amount));

                                }
                                if (GOTT.isChecked()) {
                                    gott = 1;
                                    //amount+=100;
                                    event += "GOT(Team), ";
                                    fcost.setText(String.valueOf(amount));

                                }
                                if (friendsI.isChecked()) {
                                    friendsi = 1;
                                    //amount+=80;
                                    event += "Friends(Individual), ";
                                    fcost.setText(String.valueOf(amount));

                                }
                                if (friendsT.isChecked()) {
                                    friendst = 1;
                                    //amount+=100;
                                    event += "Friends(Team), ";
                                    fcost.setText(String.valueOf(amount));

                                }
                                if (HPI.isChecked()) {
                                    hpi = 1;
                                    //amount+=100;
                                    event += "Harry Potter(Individual), ";
                                    fcost.setText(String.valueOf(amount));

                                }
                                if (HPT.isChecked()) {
                                    hpt = 1;
                                    //amount+=100;
                                    event += "Harry Potter(Team), ";
                                    fcost.setText(String.valueOf(amount));

                                }
                                if (marvelI.isChecked()) {
                                    marveli = 1;
                                    //amount+=80;
                                    event += "Marvel(Individual), ";
                                    fcost.setText(String.valueOf(amount));

                                }
                                if (marvelT.isChecked()) {
                                    marvelt = 1;
                                    //amount+=100;
                                    event += "Marvel(Team), ";
                                    fcost.setText(String.valueOf(amount));

                                }
                                if (DCI.isChecked()) {
                                    dci = 1;
                                    //amount+=80;
                                    event += "DC(Individual), ";
                                    fcost.setText(String.valueOf(amount));

                                }
                                if (DCT.isChecked()) {
                                    dct = 1;
                                    //amount+=100;
                                    event += "DC(Team), ";
                                    fcost.setText(String.valueOf(amount));

                                }


                                if (bugi == 1 || bugt == 1) {
                                    BugOffUser bugOffUser = new BugOffUser(participant1, participant2, email, contactno, college, rnd, "null", 0);
                                    crbugOff.add(bugOffUser).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                        @Override
                                        public void onSuccess(DocumentReference documentReference) {
                                            //Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                }

                                if (jci == 1 || jct == 1) {
                                    JustCodingUser justCodingUser = new JustCodingUser(participant1, participant2, email, contactno, college, rnd, "null", 0, 0);
                                    crjustCoding.add(justCodingUser).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                        @Override
                                        public void onSuccess(DocumentReference documentReference) {
                                            //Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                }
                                if (rii == 1 || rit == 1) {
                                    ReCodeItUser reCodeItUser = new ReCodeItUser(participant1, participant2, email, contactno, college, rnd, "null", 0, 0);
                                    crrecodeIt.add(reCodeItUser).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                        @Override
                                        public void onSuccess(DocumentReference documentReference) {

                                        }
                                    });
                                }

                                if (cb == 1) {
                                    CodeBuddyUser codeBuddyUser = new CodeBuddyUser(participant1, participant2, email, contactno, college, rnd, "null", amount, 0);
                                    crcodeBuddy.add(codeBuddyUser);
                                }

                                if (dq == 1) {
                                    DataQuestUser dataQuestUser = new DataQuestUser(participant1, participant2, email, contactno, college, rnd, "null", amount, 0);
                                    crdataQuest.add(dataQuestUser);
                                }
                                if (wad == 1) {
                                    WebAppDevUser webAppDevUser = new WebAppDevUser(participant1, participant2, email, contactno, college, rnd, "null", amount, 0);
                                    crwebAppDev.add(webAppDevUser);
                                }
                                if (eq == 1) {
                                    ElectroQuestUser electroQuestUser = new ElectroQuestUser(participant1, participant2, email, contactno, college, rnd, "null", amount, 0);
                                    crelectroQuest.add(electroQuestUser);
                                }
                                if (dt == 1) {
                                    DextrousUser dextrousUser = new DextrousUser(participant1, participant2, email, contactno, college, rnd, "null", amount, 0);
                                    crDextrous.add(dextrousUser);
                                }
                                if (pr == 1) {
                                    PhotoShopRoyaleUser photoShopRoyaleUser = new PhotoShopRoyaleUser(participant1, participant2, email, contactno, college, rnd, "null", amount, 0);
                                    crphotoShopRoyale.add(photoShopRoyaleUser);
                                }
                                if (q2b == 1) {
                                    Quiz2BidUser quiz2BidUser = new Quiz2BidUser(participant1, participant2, email, contactno, college, rnd, "null", amount, 0);
                                    crquiz2Bid.add(quiz2BidUser);
                                }
                                if (inst == 1) {
                                    InsightUser insightUser = new InsightUser(participant1, participant2, email, contactno, college, rnd, "null", amount, 0);
                                    crInsight.add(insightUser);
                                }
                                if (cbi == 1 || cbt == 1) {
                                    CerebroUser cerebroUser = new CerebroUser(participant1, participant2, email, contactno, college, rnd, "null", amount, 0);
                                    crCerebro.add(cerebroUser);
                                }
                                if (goti == 1 || gott == 1) {
                                    GOTUser gotUser = new GOTUser(participant1, participant2, email, contactno, college, rnd, "null", amount, 0);
                                    crGOT.add(gotUser);
                                }
                                if (friendsi == 1 || friendst == 1) {
                                    FriendsUser friendsUser = new FriendsUser(participant1, participant2, email, contactno, college, rnd, "null", amount, 0);
                                    crFriends.add(friendsUser);
                                }
                                if (hpi == 1 || hpt == 1) {
                                    HarryPotterUser harryPotterUser = new HarryPotterUser(participant1, participant2, email, contactno, college, rnd, "null", amount, 0);
                                    crharryPotter.add(harryPotterUser);
                                }
                                if (marveli == 1 || marvelt == 1) {
                                    MarvelDCUser marvelDCUser = new MarvelDCUser(participant1, participant2, email, contactno, college, rnd, "null", amount, 0);
                                    crMarvelvsDC.add(marvelDCUser);
                                }

                                if (dci == 1 || dct == 1) {
                                    DCUser dcUser = new DCUser(participant1, participant2, email, contactno, college, rnd, "null", amount, 0);
                                    crDC.add(dcUser);
                                }


                                User user = new User(participant1, participant2, volunteer, email, contactno, college, rnd, event, amount);
                                collectionReference.add(user).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                    @Override
                                    public void onSuccess(DocumentReference documentReference) {
                                        Toast.makeText(MainActivity.this, "User Registered into Database", Toast.LENGTH_SHORT).show();
                                        //startActivity(new Intent(MainActivity.this,PaymentActivity.class));
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(MainActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                                    }
                                });

                                Resources res = getResources();
                                String dontreply = String.format(res.getString(R.string.donotreply));
                                String email1 = mail.getText().toString();
                                String subject = "Pulzion'19 : E-Receipt generated for your registration";
                                String message = "Dear " + par1.getText().toString() + "\n\nGreetings from PASC!! \n\nThank you for registering for Pulzion'19. " + "Your details have been recorded and corresponding payment received. Please find below your Registration ID." + "\n\nRegistration ID: " + rnd + "\n\nThe above ID is unique to you. You can download your receipt from the My Receipts " + "section of the Pulzion'19 app using your unique Registration ID." + "\n\nOur app can be downloaded from: --------" + "Please feel free to reach out to us in case of doubts or difficulty.\nTanush Maddiwar: 7015032436\nAnother Contact: 0000000000" + "\n\nAll the Best!!\nRegards,\nPICT ACM Student Chapter\n\n\n" + dontreply;

                                //Creating SendMail object
                                SendMail sm = new SendMail(MainActivity.this, email1, subject, message);

                                //Executing sendmail to send email
                                sm.execute();

                                dialog.dismiss();
                                //startActivity(new Intent(MainActivity.this,MainActivity.class));
//                                finish();
//                                startActivity(getIntent());


                                Intent intent = new Intent(getBaseContext(), qrCode.class);
                                intent.putExtra("qrId", rnd);
                                startActivity(intent);
                            } else {
                                Toast.makeText(MainActivity.this, "Enter Correct Password", Toast.LENGTH_SHORT).show();
                            }
                        }

                    });


                }
            }

        });


    }


    @Override

    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.refresh) {
            finish();
            startActivity(getIntent());
        }
        if (id == R.id.changeTheme) {
            int count = 0;
            if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES)
                count = 1;
            final int finalCount = count;
            if (count == 1) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                finish();
                startActivity(getIntent());

            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                finish();
                startActivity(getIntent());

            }
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        //super.onCreateOptionsMenu(menu)
        return true;
    }

    protected static String getSaltString() {
        String SALTCHARS = "BDEFHIJ736KMNPQRSTUVWYZ123456A78908H70546S32";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 8) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();

        return saltStr;

    }

    void fun1(View view) {
        if (bugOffI.isChecked()) {
            //bugi=1;
            amount += 80;
            //event+="BugOff(Individual), ";
            fcost.setText(String.valueOf(amount));
        }
        else
        {
            amount-=80;
            fcost.setText(String.valueOf(amount));
        }
    }
        void fun2(View view) {
            if (bugOffT.isChecked()) {
                //bugt=1;
                amount += 100;
                //event+="BugOff(Team), ";
                fcost.setText(String.valueOf(amount));
            }
            else{
                amount-=100;
                fcost.setText(String.valueOf(amount));}
        }
        void fun3(View view){
        if (justCodingI.isChecked()) {
            //jci=1;
            amount += 80;
            //event+="JustCoding(Individual), ";
            fcost.setText(String.valueOf(amount));
        }
    else{
    amount-=80;
            fcost.setText(String.valueOf(amount));}}
        void fun4(View view){
        if (justCodingT.isChecked()) {
            //jct=1;
            amount += 100;
            //event+="JustCoding(Team), ";
            fcost.setText(String.valueOf(amount));
        }
    else{
    amount-=100;
            fcost.setText(String.valueOf(amount));}}
        void fun5(View view){
        if (reCodeItI.isChecked()) {
            //rii=1;
            amount += 80;
            //event+="ReCode It!(Individual), ";
            fcost.setText(String.valueOf(amount));

        }
    else{
    amount-=80;
            fcost.setText(String.valueOf(amount));}}
        void fun6(View view) {
            if (reCodeItT.isChecked()) {
                //rit=1;
                amount += 100;
                //event+="ReCode It!(Team), ";
                fcost.setText(String.valueOf(amount));

            }
            else{
                amount-=100;
                fcost.setText(String.valueOf(amount));

        }}
        void fun7(View view) {
            if (codeBuddy.isChecked()) {
                //cb=1;
                amount += 100;
                //event+="CodeBuddy(Team), ";
                fcost.setText(String.valueOf(amount));

            }
            else{
                amount-=100;
                fcost.setText(String.valueOf(amount));
        }}
        void fun8(View view){
        if (dataQuest.isChecked()) {
            //dq=1;
            amount += 150;
            //event+="DataQuest, ";
            fcost.setText(String.valueOf(amount));

        }
    else{
    amount-=150;
            fcost.setText(String.valueOf(amount));}}
        void fun9(View view){
        if (webAppDev.isChecked()) {
            //wad=1;
            amount += 100;
            //event+="Web-App Development, ";
            fcost.setText(String.valueOf(amount));

        }
    else{
    amount-=100;
            fcost.setText(String.valueOf(amount));}}
        void fun10(View view){
        if (electroQuest.isChecked()) {
            //eq=1;
            amount += 100;
            //event+="ElectroQuest, ";
            fcost.setText(String.valueOf(amount));

        }
    else{
    amount-=100;
            fcost.setText(String.valueOf(amount));}}
        void fun11(View view){
        if (dextrous.isChecked()) {
            //dt=1;
            amount += 100;
            //event+="Dextrous, ";
            fcost.setText(String.valueOf(amount));

        }
    else{
    amount-=100;
            fcost.setText(String.valueOf(amount));}}
        void fun12(View view) {
            if (photoShopRoyale.isChecked()) {
                //pr=1;
                amount += 50;
                //event+="Photoshop Royale, ";
                fcost.setText(String.valueOf(amount));

            }
            else{
                amount-=50;
                fcost.setText(String.valueOf(amount));}
        }
        void fun13(View view) {
            if (quiz2Bid.isChecked()) {
                //q2b=1;
                amount += 100;
                //event+="Quiz2Bid, ";
                fcost.setText(String.valueOf(amount));

            }
            else{
                amount-=100;
                fcost.setText(String.valueOf(amount));}
        }
        void fun14(View view) {
            if (insight.isChecked()) {
                //inst=1;
                amount += 50;
                //event+="Insight, ";
                fcost.setText(String.valueOf(amount));

            }
            else{
                amount-=50;
                fcost.setText(String.valueOf(amount));}
        }
        void fun15(View view){
        if (cerebroI.isChecked()) {
            //cbi=1;
            amount += 80;
            //event+="Cerebro(Individual), ";
            fcost.setText(String.valueOf(amount));

        }
    else{
    amount-=80;
            fcost.setText(String.valueOf(amount));}}
        void fun16(View view){
        if (cerebroT.isChecked()) {
            //cbt=1;
            amount += 100;
            //event+="Cerebro(Team), ";
            fcost.setText(String.valueOf(amount));

        }
    else {
    amount-=100;
            fcost.setText(String.valueOf(amount));}}
        void fun17(View view){
        if (GOTI.isChecked()) {
            //goti=1;
            amount += 80;
            //event+="GOT(Individual), ";
            fcost.setText(String.valueOf(amount));

        }
    else{
    amount-=80;
            fcost.setText(String.valueOf(amount));}}
        void fun18(View view) {
            if (GOTT.isChecked()) {
                //gott=1;
                amount += 100;
                //event+="GOT(Team), ";
                fcost.setText(String.valueOf(amount));

            }
            else{
                amount-=100;
                fcost.setText(String.valueOf(amount));}
        }
        void fun19(View view){
        if (friendsI.isChecked()) {
            //friendsi=1;
            amount += 80;
            //event+="Friends(Individual), ";
            fcost.setText(String.valueOf(amount));

        }
    else{
    amount-=80;
            fcost.setText(String.valueOf(amount));}}
        void fun20(View view){
        if (friendsT.isChecked()) {
            //friendst=1;
            amount += 100;
            //event+="Friends(Team), ";
            fcost.setText(String.valueOf(amount));

        }
    else{
    amount-=100;
            fcost.setText(String.valueOf(amount));}}
        void fun21(View view){
        if (HPI.isChecked()) {
            // hpi=1;
            amount += 80;
            //event+="Harry Potter(Individual), ";
            fcost.setText(String.valueOf(amount));

        }
    else{
    amount-=80;
            fcost.setText(String.valueOf(amount));}
    }
        void fun22(View view){
        if (HPT.isChecked()) {
            //hpt=1;
            amount += 100;
            //event+="Harry Potter(Team), ";
            fcost.setText(String.valueOf(amount));

        }
    else{
    amount-=100;
            fcost.setText(String.valueOf(amount));}
    }
        void fun23(View view){
        if (marvelI.isChecked()) {
            //marveli=1;
            amount += 80;
            //event+="Marvel(Individual), ";
            fcost.setText(String.valueOf(amount));

        }
    else{
    amount-=80;
            fcost.setText(String.valueOf(amount));}
    }
        void fun24(View view){
        if (marvelT.isChecked()) {
            //marvelt=1;
            amount += 100;
            //event+="Marvel(Team), ";
            fcost.setText(String.valueOf(amount));

        }
        else{
            amount-=100;
            fcost.setText(String.valueOf(amount));}
    }
        void fun25(View view) {
            if (DCI.isChecked()) {
                //dci=1;
                amount += 80;
                //event+="DC(Individual), ";
                fcost.setText(String.valueOf(amount));

            }
            else{

                amount-=80;
                fcost.setText(String.valueOf(amount));}
        }
        void fun26(View view){
        if (DCT.isChecked()) {
            //dct=1;
            amount += 100;
            //event+="DC(Team), ";
            fcost.setText(String.valueOf(amount));


        }
        if(!DCT.isChecked()){

            amount-=100;
            fcost.setText(String.valueOf(amount));}



    }
    boolean funpar1(){
        if (par1.getText().toString().isEmpty()) {
            par1.setError("Mandatory");
            return  false;
        } else
            return true;

    }
    boolean funvol(){
        if (vol.getText().toString().isEmpty()) {
            vol.setError("Mandatory");
            return  false;
        } else
            return true;

    }
    boolean funmail(){
        String s = mail.getText().toString();
        int n = s.length();
        int counter = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '@') {
                counter = i;
                break;
            }
        }
        String s1 = "";
        for (int i = counter + 1; i < n; i++)
            s1 += s.charAt(i);

        if (s1.equals("gmail.com") || s1.equals("yahoo.com") || s1.equals("outlook.in") || s1.equals("rediffmail.com") || s1.equals("yahoo.in") || s1.equals("outlook.com") || s1.equals("hotmail.com"))
            return true;
        else {
            return false;

        }

    }
    boolean funcon(){
        if (contact.getText().toString().equals("") || contact.getText().toString().length() != 10) {
            contact.setError("Mandatory");
            return false;
        } else
            return true;

    }
    boolean funcol(){
        if (collegeName.getText().toString().isEmpty()) {
            collegeName.setError("Mandatory");
            return false;
        } else
            return true;

    }
}
