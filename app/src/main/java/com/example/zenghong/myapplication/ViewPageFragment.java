package com.example.zenghong.myapplication;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ViewPageFragment extends Fragment {
    private ViewPageMember member;

    public static ViewPageFragment newInstance(ViewPageMember member) {
        ViewPageFragment fragment = new ViewPageFragment();
        Bundle args = new Bundle();
        args.putSerializable("member", member);
        fragment.setArguments(args);
        return fragment;
    }

    public ViewPageFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            member = (ViewPageMember) getArguments().getSerializable("member");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_page_item, container, false);

        ImageView imageView = (ImageView) view.findViewById(R.id.ivImage);
        imageView.setImageResource(member.getImage());

        TextView tvId = (TextView) view.findViewById(R.id.tvId);
        tvId.setText(String.valueOf(member.getId()));

        TextView tvName = (TextView) view.findViewById(R.id.tvName);
        tvName.setText(String.valueOf(member.getName()));

        return view;
    }
}
