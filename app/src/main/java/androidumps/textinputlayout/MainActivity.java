package androidumps.textinputlayout;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
//ruban
public class MainActivity extends AppCompatActivity {

    //TIL --> TextInputLayout

    private TextInputLayout emailTIL,mobileNumberTIL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailTIL = (TextInputLayout) findViewById(R.id.emailTIL);
        mobileNumberTIL = (TextInputLayout) findViewById(R.id.mobileNumberTIL);
    }

    public void funcRegister(View v){
        String email = emailTIL.getEditText().getText().toString().trim();
        String mobileNumber = mobileNumberTIL.getEditText().getText().toString().trim();
        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailTIL.setError("Invalid mail ID!!!");
        }else if(!Patterns.PHONE.matcher(mobileNumber).matches()){
            mobileNumberTIL.setError("Invalid mobile number");
        }else{
            Toast.makeText(this,"Register successful",Toast.LENGTH_LONG).show();
            emailTIL.setErrorEnabled(false);
            mobileNumberTIL.setErrorEnabled(false);
        }

    }

}
