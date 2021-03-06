/**
 * Copyright (C) futuretek AG 2016
 * All Rights Reserved
 *
 * @author Artan Veliju
 */
package survey.android.futuretek.ch.ft_survey;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SkillsActivity extends BaseActivity {
    private ListView listview;
    public List<String> productList = new ArrayList<String>();
    private ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.BLACK));

        listview = (ListView) findViewById(R.id.listView);
        View mainTextView = findViewById(R.id.textLayout);
        mainTextView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        List<String> textArray = new ArrayList<>(1);
        textArray.add("Please add a developer skill");
        animateText(textArray);
        productList.clear();
        productList = getDatabase().getAllSkills();
        adapter = new ListAdapter(this);
        listview.setAdapter(adapter);
    }

    private class ListAdapter extends BaseAdapter {
        LayoutInflater inflater;
        ViewHolder viewHolder;

        public ListAdapter(Context context) {
            inflater = LayoutInflater.from(context);
        }

        public int getCount() {
            return productList.size();
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.list_row, null);
                viewHolder = new ViewHolder();
                viewHolder.textView = (TextView) convertView.findViewById(R.id.textView1);
                viewHolder.delBtn = (Button) convertView.findViewById(R.id.deleteBtn);
                viewHolder.delBtn.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        ViewGroup row = ((ViewGroup) v.getParent());
                        String id = ((TextView) row.findViewById(R.id.textView1)).getText().toString();
                        getDatabase().deleteSkill(id);
                        productList.remove(id);
                        adapter.notifyDataSetChanged();
                    }
                });
                viewHolder.addBtn = (Button) convertView.findViewById(R.id.addBtn);
                viewHolder.addBtn.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        requestOrEditSkillName(null);
                    }
                });
                viewHolder.editBtn = (Button) convertView.findViewById(R.id.editBtn);
                viewHolder.editBtn.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        ViewGroup row = ((ViewGroup) view.getParent());
                        String id = ((TextView) row.findViewById(R.id.textView1)).getText().toString();
                        getDatabase().deleteSkill(id);
                        requestOrEditSkillName(id);
                    }
                });
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.textView.setText(productList.get(position));
            return convertView;
        }
    }

    private class ViewHolder {
        TextView textView;
        Button delBtn;
        Button addBtn;
        Button editBtn;
    }

    private void requestOrEditSkillName(String defaultText) {
        openInputDialog(new View.OnClickListener() {
            public void onClick(View v) {
                String skillName = ((EditText) v.findViewById(R.id.userInput)).getText().toString();
                if (skillName != null && !skillName.isEmpty()) {
                    insertSkill(skillName);
                }
            }
        }, defaultText);
    }

    private void insertSkill(String skill) {
        try {
            getDatabase().putSkill(skill);
            productList = getDatabase().getAllSkills();
            adapter.notifyDataSetChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}