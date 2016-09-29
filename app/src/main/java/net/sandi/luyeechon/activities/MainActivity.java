package net.sandi.luyeechon.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import net.sandi.luyeechon.R;
import net.sandi.luyeechon.adapters.MotivatorAdapter;
import net.sandi.luyeechon.data.vos.MotivatorVO;
import net.sandi.luyeechon.fragments.MotivatorFragment;
import net.sandi.luyeechon.utils.MMFontUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

//    @BindView(R.id.rv_motivator)
//    RecyclerView rvMotivator;

    @BindView(R.id.navigation_view)
    NavigationView navigationView;

    private MotivatorAdapter mMotivatorAdapter;
    private List<MotivatorVO> motivatorVOs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this, this);

        setSupportActionBar(toolbar);

        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        Menu leftMenu = navigationView.getMenu();
        MMFontUtils.applyMMFontToMenu(leftMenu);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //startActivity(new Intent(MainActivity.this,QuizActivity.class));

                Intent intent=QuizActivity.newIntent();
                startActivity(intent);

                /*
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
            }
        });

        MotivatorFragment motivatorFragment = MotivatorFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_container,motivatorFragment)
                .commit();

     //   QuizActivity.loadQuiz();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.action_settings:
                return true;
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(final MenuItem item) {
        item.setChecked(true);
        drawerLayout.closeDrawers();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (item.getItemId()) {
                    case R.id.menu_health_topics:
                    //    navigateToHealth();
                        break;
                    case R.id.menu_quiz:
                    //    navigateToQuiz();
                        break;
                    case R.id.menu_sate_khon_arr:
                   //     navigateToMotivator();
                        break;
                    case R.id.menu_short_jokes:
                   //     navigateToJoke();
                        break;


                }
            }
        }, 100); //to close drawer smoothly.

        return true;
    }
}
