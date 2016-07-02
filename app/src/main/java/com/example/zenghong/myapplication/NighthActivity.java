package com.example.zenghong.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class NighthActivity extends AppCompatActivity {
    private List<ViewPageMember> memberList;
    private ViewPager vpMember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nighth);

        List<ViewPageMember> members = getMemberList();
        MemberAdapter memberAdapter = new MemberAdapter(getSupportFragmentManager(), members);

        vpMember = (ViewPager) findViewById(R.id.vpMemeber);
        vpMember.setAdapter(memberAdapter);
    }

    private List<ViewPageMember> getMemberList() {
        memberList = new ArrayList<>();
        memberList.add(new ViewPageMember(12, R.drawable.p01, "sdadfa"));
        memberList.add(new ViewPageMember(13, R.drawable.p02, "wwwfasadfa"));
        memberList.add(new ViewPageMember(14, R.drawable.p03, "sdadfaßdf"));
        memberList.add(new ViewPageMember(15, R.drawable.p04, "ssss222"));
        memberList.add(new ViewPageMember(16, R.drawable.p05, "sewwe"));
        memberList.add(new ViewPageMember(17, R.drawable.p06, "asdfaxzxc"));
        memberList.add(new ViewPageMember(18, R.drawable.p07, "s"));
        memberList.add(new ViewPageMember(19, R.drawable.p08, "223"));
        return memberList;
    }

    private class MemberAdapter extends FragmentStatePagerAdapter {
        List<ViewPageMember> memberList;

        private MemberAdapter(FragmentManager fm, List<ViewPageMember> memberList) {
            super(fm);
            this.memberList = memberList;
        }

        @Override
        public int getCount() {
            return memberList.size();
        }

        @Override
        public Fragment getItem(int position) {
            return ViewPageFragment.newInstance(memberList.get(position));
        }
    }

    public void onFirstClick(View view) {
        vpMember.setCurrentItem(0);
    }

    public void onLastClick(View view) {
        vpMember.setCurrentItem(memberList.size() - 1);
    }
}
