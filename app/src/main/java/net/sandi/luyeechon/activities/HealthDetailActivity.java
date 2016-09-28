package net.sandi.luyeechon.activities;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import net.sandi.luyeechon.LuYeeChonApp;
import net.sandi.luyeechon.R;
import net.sandi.luyeechon.data.vos.HealthVO;
import net.sandi.luyeechon.data.persistence.LuYeeChonContract;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by UNiQUE on 9/20/2016.
 */
public class HealthDetailActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor>{

    private static final String IE_HEALTH_TOPIC_NAME = "IE_HEALTH_TOPIC_NAME";


    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.fab_detail)
    FloatingActionButton fab;

    @BindView(R.id.tv_health_desc)
    TextView tvHealthDesc;

    @BindView(R.id.tv_health)
    ImageView ivHealth;

    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;

    @BindString(R.string.health_list_detail_name) String HEALTH_IMAGE_TRANSITION_NAME;

    private String mHealthTitle;
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

        ViewCompat.setTransitionName(ivHealth, HEALTH_IMAGE_TRANSITION_NAME);

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

        mHealthTitle = getIntent().getStringExtra(IE_HEALTH_TOPIC_NAME);
        tvHealthDesc.setText(mHealth.getHealthDes() );

        Glide.with(ivHealth.getContext())
                .load(mHealth.getImage())
                .centerCrop()
                .placeholder(R.drawable.lime)
                .into(ivHealth);

        collapsingToolbar.setTitle(mHealthTitle);

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
        tvHealthDesc.setText(healthVO.getHealthDes());

        Glide.with(ivHealth.getContext())
                .load(healthVO.getImage())
                .centerCrop()
                .placeholder(R.drawable.lime)
                .into(ivHealth);

        collapsingToolbar.setTitle(mHealthTitle);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(this,
                LuYeeChonContract.HealthEntry.buildHealthUriWithTitle(mHealthTitle),
                null,
                null,
                null,
                null
        );
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        if (data != null && data.moveToFirst()) {
            mHealth = HealthVO.parseFromCursor(data);
//            mHealth.setImages(AttractionVO.loadAttractionImagesByTitle(mAttraction.getTitle()));

            bindData(mHealth);
        }

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}
