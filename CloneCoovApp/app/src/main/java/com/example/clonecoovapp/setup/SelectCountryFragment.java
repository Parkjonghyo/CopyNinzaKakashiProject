package com.example.clonecoovapp.setup;

import android.app.Activity;
import android.content.Intent;
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

import com.example.clonecoovapp.MainActivity;
import com.example.clonecoovapp.R;
import com.example.clonecoovapp.common.CommonVal;

import java.util.ArrayList;
import java.util.List;

public class SelectCountryFragment extends Fragment {

    RecyclerView rcv_country;
    TextView title;
    Button btn_select_country;
    Activity sActivity;

    public SelectCountryFragment(Activity sActivity) {
        this.sActivity = sActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_select_country, container, false);

        btn_select_country = rootView.findViewById(R.id.btn_select_country);
        title = rootView.findViewById(R.id.title);

        changeSpecialChars(title, "국가 및 지역");

        List<OptionVO> list = tempInit();

        SetupAdapter adapter = new SetupAdapter(getContext(), list);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rcv_country = rootView.findViewById(R.id.rcv_country);
        rcv_country.setAdapter(adapter);
        rcv_country.setLayoutManager(manager);

        btn_select_country.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(sActivity, MainActivity.class);
                startActivity(intent);
                sActivity.finish();
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

        tempList.add(new OptionVO("대한민국", true, true, CommonVal.SEL_COUNTRY));
        tempList.add(new OptionVO("가나", false, true, CommonVal.SEL_COUNTRY));
        tempList.add(new OptionVO("가봉", false, true, CommonVal.SEL_COUNTRY));
        tempList.add(new OptionVO("가이아나", false, true, CommonVal.SEL_COUNTRY));
        tempList.add(new OptionVO("감비아", false, true, CommonVal.SEL_COUNTRY));
        tempList.add(new OptionVO("과테말라", false, true, CommonVal.SEL_COUNTRY));
        tempList.add(new OptionVO("그레나다", false, true, CommonVal.SEL_COUNTRY));
        tempList.add(new OptionVO("미국", false, true, CommonVal.SEL_COUNTRY));
        tempList.add(new OptionVO("중국", false, true, CommonVal.SEL_COUNTRY));

        return tempList;
    }

}