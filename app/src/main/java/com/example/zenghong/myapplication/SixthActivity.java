package com.example.zenghong.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SixthActivity extends AppCompatActivity {
    private ListView lvMember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth);
        findViews();
    }

    public void findViews() {
        lvMember = (ListView) findViewById(R.id.lvMember);
        lvMember.setAdapter(new MemberAdaper(this));
        lvMember.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Member member = (Member) parent.getItemAtPosition(position);
                String text = "ID = " + member.getId() + " , name = " + member.getName();
                Toast.makeText(SixthActivity.this, text, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private class MemberAdaper extends BaseAdapter {
        private LayoutInflater layoutInflater;
        private List<Member> memberList;

        public MemberAdaper(Context context) {
            layoutInflater = LayoutInflater.from(context);
            memberList = new ArrayList<>();
            memberList.add(new Member(23, R.drawable.name, "safasdf"));
            memberList.add(new Member(25, R.drawable.name, "safasdfasdf"));
            memberList.add(new Member(26, R.drawable.name, "sd"));
            memberList.add(new Member(27, R.drawable.name, "safasdf"));
            memberList.add(new Member(28, R.drawable.name, "23"));
            memberList.add(new Member(29, R.drawable.name, "sd"));
            memberList.add(new Member(20, R.drawable.name, "saf"));
            memberList.add(new Member(231, R.drawable.name, "safdfadfasdf"));
        }

        @Override
        public int getCount() {
            return memberList.size();
        }

        @Override
        public Object getItem(int position) {
            return memberList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return memberList.get(position).getId();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = layoutInflater.inflate(R.layout.listview_item, parent, false);
            }

            Member member = memberList.get(position);

            ImageView ivImage = (ImageView) convertView.findViewById(R.id.ivImage);
            ivImage.setImageResource(member.getImage());

            TextView tvId = (TextView) convertView.findViewById(R.id.tvId);
            tvId.setText(String.valueOf(member.getId()));

            TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
            tvName.setText(String.valueOf(member.getName()));
            return convertView;
        }
    }

    private class Member {
        public String Name;
        public int Image;
        public long Id;

        public int getImage() {
            return Image;
        }

        public void setImage(int image) {
            Image = image;
        }

        public long getId() {
            return Id;
        }

        public void setId(long id) {
            Id = id;
        }

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }

        public Member(long id, int image, String name) {
            Name = name;
            Image = image;
            Id = id;
        }
    }
}
