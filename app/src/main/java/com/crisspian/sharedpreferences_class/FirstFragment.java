package com.crisspian.sharedpreferences_class;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.crisspian.sharedpreferences_class.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private SharedPreferences sharedPreferences;
    private String sharedPreferencesFile = "FILE_PREFERENCES_NAME";

    public static final String INT_KEY = "INT_KEY";
    public static final String TEXT_KEY = "TEXT_KEY";
    public static final String DEC_KEY = "DEC_KEY";
    public static final String BOOLEAN_KEY ="BOOLEAN_KEY";

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        sharedPreferences = getContext().getSharedPreferences(sharedPreferencesFile, Context.MODE_PRIVATE);

        binding.saveBtnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });


        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void saveData() {
        if (!binding.et01FirstFragment.getText().toString().isEmpty()) {
            sharedPreferences.edit()
                    .putInt(INT_KEY, Integer.parseInt(binding.et01FirstFragment.getText().toString()))
                    .apply();
        }
        String text = binding.et02FirstFragment.getText().toString();
        if (!text.isEmpty()) {
            sharedPreferences.edit().putString(TEXT_KEY, text)
                    .apply();
        }

        Boolean check = binding.switch1FirstFragment.isChecked();
        sharedPreferences.edit().putBoolean(BOOLEAN_KEY, check).apply();

        if (!binding.et03FirstFragment.getText().toString().isEmpty()) {
            float decimal = Float.parseFloat(binding.et03FirstFragment.getText().toString());
            sharedPreferences.edit().putFloat(DEC_KEY, decimal).apply();
        }

    }
}