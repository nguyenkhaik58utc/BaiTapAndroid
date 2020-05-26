package com.example.bigexample;


import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.bigexample.Data.BaseComment;
import com.example.bigexample.Data.DataBaseComment;
import com.example.bigexample.Data.DataBaseLike;
import com.example.bigexample.Data.DataBaseUser;
import com.example.bigexample.Golobal.Golobal;
import com.example.bigexample.models.Account;
import com.example.bigexample.models.Comment;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragment_content_post extends Fragment {

    ImageView imageContentPost;
    TextView nameUserContentPost;
    TextView priceUserContentPost;
    TextView addressContentPost;
    TextView describeContentPost;
    ImageView imageAddressContentPost1;
    ImageView imageAddressContentPost2;
    TextView txtNumberLike;
    TextView txtNumberCmt;
    TextView txtCommentContent;
    ImageView imgLikeContent;
    DataBaseComment dataCmt;
    DataBaseUser dataUser;
    DataBaseLike dataLike;
    public static ListView lst;
    public static EditText txtNewComment;
    ImageView imgSendComment;
    public ArrayList<Comment> lstCmt;
    public Bundle bundle1;
    public static TextView txtCancelEditCmt;

    public fragment_content_post() {
        // Required empty public constructor
    }

    @Override
    public void onStart() {
        super.onStart();
        dataCmt.openDB();
        dataUser.openDB();
        dataLike.openDB();
    }

    @Override
    public void onStop() {
        super.onStop();
        dataUser.closeDB();
        dataCmt.closeDB();
        dataLike.closeDB();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_content_post, container, false);

        nameUserContentPost = view.findViewById(R.id.nameUserContentPost);
        addressContentPost = view.findViewById(R.id.addressContentPost);
        priceUserContentPost = view.findViewById(R.id.priceUserContentPost);
        describeContentPost = view.findViewById(R.id.describeContentPost);
        imageAddressContentPost1 = view.findViewById(R.id.imageAddressContentPost1);
        imageAddressContentPost2 = view.findViewById(R.id.imageAddressContentPost2);
        txtCancelEditCmt = view.findViewById(R.id.txtCancelEditCmt);
        txtNumberLike = view.findViewById(R.id.txtLikeContent);
        txtNumberCmt = view.findViewById(R.id.txtCommentContent);
        txtNewComment = view.findViewById(R.id.txtNewComment);
        imgSendComment = view.findViewById(R.id.imgSendComment);
        txtCommentContent = view.findViewById(R.id.txtCommentContent);
        imgLikeContent = view.findViewById(R.id.imgLikeContent);
        lst = view.findViewById(R.id.lstComment);
        dataCmt = new DataBaseComment(getActivity());
        dataUser = new DataBaseUser(getActivity());
        dataLike = new DataBaseLike(getActivity());

        final Bundle bundle = getArguments();
        String query = "Select * from tableComment where idPost = " + bundle.getInt("idPost");
        final Cursor cursor = dataCmt.getWritableDatabase().rawQuery(query,null);
        lstCmt = getAllCmt(cursor);
        lst.setAdapter(new BaseComment(getActivity(),lstCmt));

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(lstCmt.get(position).getIdUserCmt() == Golobal.getIdUser())
                {
                    Bundle bundleCmt = new Bundle();
                    bundleCmt.putInt("idCmt",lstCmt.get(position).getId());
                    bundleCmt.putString("contentCmt",lstCmt.get(position).getContentCmt());
                    Golobal.setIdCmt(lstCmt.get(position).getId());
                    Golobal.setContentCmt(lstCmt.get(position).getContentCmt());
                    FragmentEditDeletCmt editDeletCmt = new FragmentEditDeletCmt();
                    editDeletCmt.setArguments(bundleCmt);
                    editDeletCmt.show(getFragmentManager(),"FragmentEditDeletCmt");
                }
            }
        });

        if(bundle != null)
        {
//            imageContentPost.setImageURI(Uri.parse(bundle.getString("imgAddress2")));
            nameUserContentPost.setText(bundle.getString("name"));
            addressContentPost.setText(bundle.getString("address"));
            priceUserContentPost.setText(bundle.getString("price"));
            describeContentPost.setText(bundle.getString("describe"));
            txtNumberLike.setText(String.valueOf(bundle.getInt("numberLike")));
            txtNumberCmt.setText(String.valueOf(bundle.getInt("numberCmt")));
            if(bundle.getString("imgAddress1").equals("") && bundle.getString("imgAddress2").equals(""))
            {
                imageAddressContentPost1.setVisibility(View.GONE);
                imageAddressContentPost2.setVisibility(View.GONE);
            }
            else
            {
                imageAddressContentPost1.setImageURI(Uri.parse(bundle.getString("imgAddress1")));
                imageAddressContentPost2.setImageURI(Uri.parse(bundle.getString("imgAddress2")));
            }
        }
        nameUserContentPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundleUser = new Bundle();
                bundleUser.putString("nameUserPost",nameUserContentPost.getText().toString());
                ProfireUser profireUser = new ProfireUser();
                profireUser.setArguments(bundleUser);
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container,profireUser).addToBackStack("FragmentHome")
                        .commit();
            }
        });
        bundle1 = new Bundle();
        imageAddressContentPost1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bundle1.putString("image",bundle.getString("imgAddress1"));
                fragment_image_popup imagePopup = new fragment_image_popup();
                imagePopup.setArguments(bundle1);
                imagePopup.show(getFragmentManager(), "ImagePopup");
            }
        });

        imageAddressContentPost2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle1.putString("image",bundle.getString("imgAddress2"));
                fragment_image_popup imagePopup = new fragment_image_popup();
                imagePopup.setArguments(bundle1);
                imagePopup.show(getFragmentManager(), "ImagePopup");
            }
        });

        imgSendComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Golobal.getCheckEditCmt() == 1)
                {

                    long resultUpdate = dataCmt.Update(Golobal.getIdCmt(), txtNewComment.getText().toString());
                    if (resultUpdate == 0) {
                        Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
                    } else if (resultUpdate == 1) {
                        Toast.makeText(getActivity(), "Successsfully updated", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getActivity(), "Error, multiple records updated", Toast.LENGTH_SHORT).show();
                    }
                    txtNewComment.setText("");
                    String query1 = "Select * from tableComment where idPost = " + bundle.getInt("idPost");
                    final Cursor cursor1 = dataCmt.getWritableDatabase().rawQuery(query1,null);
                    lstCmt = getAllCmt(cursor1);
                    lst.setAdapter(new BaseComment(getActivity(),lstCmt));
                    Golobal.setCheckEditCmt(0);
                    txtCancelEditCmt.setVisibility(View.INVISIBLE);
                }
                else
                {
                    if(txtNewComment.getText().toString() != null)
                    {
                        String query = "SELECT *  FROM tableComment";
                        int maxId  = 0;
                        Cursor cursor = dataCmt.getWritableDatabase().rawQuery(query,null);
                        ArrayList<Integer> users = getIdCmt(cursor);
                        for (int i = 0; i < users.size() ; i++ )
                        {
                            if (maxId < users.get(i)) maxId = users.get(i);
                        }
                        int idPost = bundle.getInt("idPost");
                        int idUser = Golobal.getIdUser();
                        String a = txtNewComment.getText().toString();
                        long resultAdd = dataCmt.Insert(maxId + 1,idPost, idUser,a);
                        if(resultAdd == -1){
                            Toast.makeText(getActivity(), "Lỗi rồi!",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(getActivity(), "Đã thêm Comment", Toast.LENGTH_SHORT).show();
                        }
                        txtNewComment.setText("");
                        txtCommentContent.setText(String.valueOf( Integer.parseInt(txtCommentContent.getText().toString()) + 1 ));
                        String query1 = "Select * from tableComment where idPost = " + bundle.getInt("idPost");
                        final Cursor cursor1 = dataCmt.getWritableDatabase().rawQuery(query1,null);
                        lstCmt = getAllCmt(cursor1);
                        lst.setAdapter(new BaseComment(getActivity(),lstCmt));
                    }
                }
            }
        });

        txtCancelEditCmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Golobal.setCheckEditCmt(0);
                txtCancelEditCmt.setVisibility(View.INVISIBLE);
                txtNewComment.setText("");
            }
        });

        imgLikeContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String queryLike = "SELECT * FROM tableLike WHERE idpost = " + bundle.getInt("idPost") + " and iduser = " + Golobal.getIdUser();
                Cursor cursor1 = dataLike.getWritableDatabase().rawQuery(queryLike,null);
                ArrayList<Integer> arrayList = new ArrayList<>();
                while (cursor1.moveToNext())
                {
                    arrayList.add(Integer.parseInt(cursor1.getString(0)));
                }
                if(arrayList.size()!= 0)
                {
                    Toast.makeText(getActivity(), "Đã thích",Toast.LENGTH_SHORT).show();
                }
                else {
                    String query = "SELECT *  FROM tableLike";
                    int maxId  = 0;
                    Cursor cursor2 = dataLike.getWritableDatabase().rawQuery(query,null);
                    ArrayList<Integer> users = getIdCmt(cursor2);
                    for (int i = 0; i < users.size() ; i++ )
                    {
                        if (maxId < users.get(i)) maxId = users.get(i);
                    }
                    long resultAdd = dataLike.Insert(maxId + 1,bundle.getInt("idPost"), Golobal.getIdUser());
                    if(resultAdd == -1){
                        Toast.makeText(getActivity(), "Lỗi rồi!",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        txtNumberLike.setText(String.valueOf( Integer.parseInt(txtNumberLike.getText().toString()) + 1 ));
                    }
                }
            }
        });

        return view;
    }

    public ArrayList<Comment> getAllCmt(Cursor cursor)
    {
        ArrayList<Comment> lstCmt= new ArrayList<>();
        ArrayList<Comment> Cmt= new ArrayList<>();
        ArrayList<Account> lstAccount = new ArrayList<>();

        while (cursor.moveToNext())
        {
            Cmt.add(new Comment(Integer.parseInt(cursor.getString(0)),Integer.parseInt(cursor.getString(2)),cursor.getString(3)));
        }

        for(int i= 0;i<Cmt.size();i++)
        {
            String queryUser = "select * from Account where _id = " + Cmt.get(i).getIdUserCmt();
            Cursor cursor1 = dataUser.getWritableDatabase().rawQuery(queryUser,null);
            while (cursor1.moveToNext())
            {
                lstAccount.add(new Account(Integer.parseInt(cursor1.getString(0)),cursor1.getString(1),cursor1.getString(5)));
            }
        }
        for(int  i = 0; i < Cmt.size() ; i++)
        {
            lstCmt.add(new Comment(Cmt.get(i).getId(),Cmt.get(i).getIdUserCmt(),lstAccount.get(i).getImgAvatar(),lstAccount.get(i).getNameUser(),Cmt.get(i).getContentCmt()));
        }

        return lstCmt;
    }

    public ArrayList<Integer> getIdCmt(Cursor cursor) {
        ArrayList<Integer> cmts = new ArrayList<Integer>();

        if(cursor == null)
        {
            cmts.add(0);
        }
        else {
            while (cursor.moveToNext()) {
                cmts.add(Integer.parseInt(cursor.getString(0)));
            }
        }
        return cmts;
    }

    public ArrayList<Integer> getIdLike(Cursor cursor) {
        ArrayList<Integer> likes = new ArrayList<Integer>();

        if(cursor == null)
        {
            likes.add(0);
        }
        else {
            while (cursor.moveToNext()) {
                likes.add(Integer.parseInt(cursor.getString(0)));
            }
        }
        return likes;
    }

}
