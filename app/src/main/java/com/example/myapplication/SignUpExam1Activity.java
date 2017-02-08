package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

// 변수를 선언하고

public class SignUpExam1Activity extends AppCompatActivity implements View.OnClickListener {


    public static final int REQUEST_CODE_SIGN_UP = 1000;
    private EditText mIdEditText;          // 아이디 입력 에디트 선언
    private EditText mPassEditText;        // 패드워드 입력 에디트 선언
    private EditText mPass2EditText;       // 패스워드 확인 에디트 선언
    private EditText mEmailEditText;       // 이메일 입력 에디트 선언
    private RadioGroup mGenderGroup;       // 라디오 성별 그룹 선언

    private ArrayList<EditText> mEditTextList;  //EditText 타입을 담을 그릇 선언
    private String mGenger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);                    // 항상 시작은 onCreate
        setContentView(R.layout.activity_sign_up_exam1);       // signup_exam1 레이아웃과 연결

        mEditTextList = new ArrayList<>();

        mIdEditText = (EditText) findViewById(R.id.id_edit); // 위에서 선언한 변수들을 연결된
        mPassEditText = (EditText) findViewById(R.id.pass_edit); //  레이아웃의 동작들과 연결
        mPass2EditText = (EditText) findViewById(R.id.pass2_edit);
        mEmailEditText = (EditText) findViewById(R.id.email_edit);

        mEditTextList.add(mIdEditText);           // 연결된 Edit Text 타입의 변수들을
        mEditTextList.add(mPassEditText);         // 배열에 넣음
        mEditTextList.add(mPass2EditText);
        mEditTextList.add(mEmailEditText);

        mGenderGroup = (RadioGroup) findViewById(R.id.gender_group); // 레이아웃과 연결
        mGenderGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            //젠더그룹에 체크 박스 이벤트 리스너 객체를 생성 및 설정한다.

            @Override // 각종 체크 박스 이벤트는 onCheckedChanged 함수를 통해 전달된다.
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                mGenger = ((RadioButton) findViewById(checkedId)).getText().toString();
            }  //체크박스를 라디오버튼 타입으로 타입을 변경하여 텍스트를 받아 String 형태로 나타냄
        });

        findViewById(R.id.reset_button).setOnClickListener(this); //리셋버튼과 연결해서 OnClick으로 설정한다.
        findViewById(R.id.sign_up_button).setOnClickListener(this);
    }

    @Override // 상위클래스가 가진 메소드를 하위클래스에서 재정의하여 사용한다.
    public void onClick(View v) {
        switch (v.getId()) { // id 변수를 받아서 그에 맞는 케이스 사용
            case R.id.reset_button:
                reset();    // 메소드 사용
                break;
            case R.id.sign_up_button:
                signUp();  // 메소드 사용
                break;
        }
    }
    private void reset() {
        for (EditText editText : mEditTextList) {  // 리스트 안의 변수를 하나씩 사용
            editText.setText("");           // 모두다 "" 로 공백으로 만듬
        }
        mGenderGroup.clearCheck(); // 라디오그룹의 체크를 다시 깨끗하게 만듬
    }

    private void signUp() {            // 가입 절차를 위한 메소드
        if (!isValid()) {   // 아이디를 비교해서 아닐 경우
            Toast.makeText(this, "모두 입력 해 주셔야 합니다", Toast.LENGTH_SHORT).show();
        } else if (!isValidPassword()) {  // 비교를 해서 아닐 경우
            Toast.makeText(this, "비밀번호가 다릅니다", Toast.LENGTH_SHORT).show();
        } else {
            // 가입
            Intent intent = new Intent(this, SignUpExam2Activity.class); // 다른 액티비티로 실행
            intent.putExtra("id", mIdEditText.getText().toString());    // 데이터 전달
            intent.putExtra("pass", mPassEditText.getText().toString());
            intent.putExtra("email", mEmailEditText.getText().toString());
            intent.putExtra("gender", mGenger);

            startActivityForResult(intent, REQUEST_CODE_SIGN_UP);
            //startActivity 는 단순히 어떠한 액티비티를 시작하기 위한 용도
            //startActivityForResult 는 액티비티를 통해 어떠한 결과값을 받기 위해 사용
        }
    }

    private boolean isValid() {
        for (EditText editText : mEditTextList) {  // ArrayList 에서 하나씩 반복해서 사용
            if (TextUtils.isEmpty(editText.getText().toString())) { //입력값이 비어있을 경우
                return false;
            }
        }
        if (mGenderGroup.getCheckedRadioButtonId() == -1) { // 체크박스의 값이 -1 일경우 false
            return false;
        }
        return true;
    }
    private boolean isValidPassword() { // 패스워드의 값을 비교하는 메소드
        return mPassEditText.getText().toString().equals(mPass2EditText.getText().toString());
    }


    @Override // 다른 액티비티로 넘어갔다가 다시 돌아올 때 사용하는 기본 메소드 onActivityResult
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_SIGN_UP &&
                resultCode == RESULT_OK) {
            Toast.makeText(this, "확인 버튼을 누르셨습니다", Toast.LENGTH_SHORT).show();
        }
    }


}
