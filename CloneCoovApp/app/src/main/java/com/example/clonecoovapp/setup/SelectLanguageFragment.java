package com.example.clonecoovapp.setup;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.clonecoovapp.R;
import com.example.clonecoovapp.common.CommonVal;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class SelectLanguageFragment extends Fragment {

    RecyclerView rcv_language;
    TextView title;
    MaterialButton btn_select_language;
    SetupActivity sActivity;

    public SelectLanguageFragment(SetupActivity sActivity) {
        this.sActivity = sActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_select_language, container, false);

        btn_select_language = rootView.findViewById(R.id.btn_select_language);
        title = rootView.findViewById(R.id.title);

        changeSpecialChars(title, "언어");

        List<OptionVO> list = tempInit();

        SetupAdapter adapter = new SetupAdapter(getContext(), list);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rcv_language = rootView.findViewById(R.id.rcv_language);
        rcv_language.setAdapter(adapter);
        rcv_language.setLayoutManager(manager);

        btn_select_language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sActivity.changeFragment(new SelectCountryFragment(sActivity));
            }
        });

        return rootView;
    }

    private void changeSpecialChars(TextView title, String word) {
        String content = title.getText().toString();
        SpannableString spannableString = new SpannableString(content);

        int start = content.indexOf(word);
        int end = start + word.length();
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#0036b0")), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        title.setText(spannableString);
    }

    public List<OptionVO> tempInit(){

        List<OptionVO> tempList = new ArrayList<>();

        tempList.add(new OptionVO("한국어", true, true, CommonVal.SEL_LANGUAGE));
        tempList.add(new OptionVO("영어", false, true, CommonVal.SEL_LANGUAGE));
        tempList.add(new OptionVO("일본어", false, true, CommonVal.SEL_LANGUAGE));
        tempList.add(new OptionVO("프랑스어", false, false, CommonVal.SEL_LANGUAGE));
        tempList.add(new OptionVO("중국어", false, false, CommonVal.SEL_LANGUAGE));
        tempList.add(new OptionVO("아랍어", false, false, CommonVal.SEL_LANGUAGE));
        tempList.add(new OptionVO("힌두어", false, false, CommonVal.SEL_LANGUAGE));
        tempList.add(new OptionVO("독일어", false, false, CommonVal.SEL_LANGUAGE));
        tempList.add(new OptionVO("러시아어", false, false, CommonVal.SEL_LANGUAGE));

        return tempList;
    }

}