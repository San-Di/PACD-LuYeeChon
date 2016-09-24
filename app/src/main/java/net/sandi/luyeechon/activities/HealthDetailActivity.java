package net.sandi.luyeechon.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import net.sandi.luyeechon.LuYeeChonApp;
import net.sandi.luyeechon.R;
import net.sandi.luyeechon.data.vos.HealthVO;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by UNiQUE on 9/20/2016.
 */
public class HealthDetailActivity extends AppCompatActivity {

    private static final String IE_HEALTH_TOPIC_NAME = "IE_HEALTH_TOPIC_NAME";


    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.fab)
    FloatingActionButton fab;

    @BindView(R.id.tv_attraction_desc)
    TextView tvAttractionDesc;

    @BindView(R.id.iv_attraction)
    ImageView ivAttraction;

    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;

    private String mAttractionTitle;
    private static HealthVO mHealth;


    public static Intent newIntent(HealthVO healthVO) {
        Intent intent = new Intent(LuYeeChonApp.getContext(), HealthDetailActivity.class);
        intent.putExtra(IE_HEALTH_TOPIC_NAME,healthVO.getHealthTitle());
        mHealth=healthVO;
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_health_detail);

        ButterKnife.bind(this, this);

        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        mAttractionTitle = getIntent().getStringExtra(IE_HEALTH_TOPIC_NAME);
        tvAttractionDesc.setText(mHealth.getHealthDes() );
        collapsingToolbar.setTitle(mAttractionTitle);

        /*
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Context context = MyanmarAttractionsApp.getContext();
            String transitionName = context.getResources().getString(R.string.attraction_list_detail_transition_name);
            ivAttraction.setTransitionName(transitionName);
        }
        */

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {

            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //overridePendingTransition(R.anim.pop_enter, R.anim.pop_exit);
    }
    private void bindData(HealthVO healthVO) {
        tvAttractionDesc.setText(healthVO.getHealthDes() + "\n\n"
                + healthVO.getHealthDes());

        /*
        String imageUrl = MyanmarAttractionsConstants.IMAGE_ROOT_DIR + attraction.getImages()[0];
        Glide.with(ivAttraction.getContext())
                .load(imageUrl)
                .centerCrop()
                .placeholder(R.drawable.stock_photo_placeholder)
                .error(R.drawable.stock_photo_placeholder)
                .into(ivAttraction);
                */

        collapsingToolbar.setTitle(mAttractionTitle);
    }

}
