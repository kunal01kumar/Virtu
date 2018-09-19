package com.virtu.kunal.virtu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private EditText ed_school_url;
    private EditText ed_user_id;
    private EditText ed_password;
    private Button b_login;
    private CheckBox cb_remember_me;
    public User_info user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ed_school_url = (EditText) findViewById(R.id.et_school_url);
        ed_user_id = (EditText) findViewById(R.id.et_user_id);
        ed_password = (EditText) findViewById(R.id.et_password);
        b_login = (Button) findViewById(R.id.b_login);
        cb_remember_me = (CheckBox) findViewById(R.id.cb_remember_me);

        b_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });

    }

    private void attemptLogin() {

        final String school = ed_school_url.getText().toString();
        final String password = ed_password.getText().toString();
        final String username = ed_user_id.getText().toString();
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String URL = "http://" + school + ".cutebrains.com/oauth/token";
        //String URL = "http://schools.cutebrains.com/oauth/token";


        StringRequest MyStringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("Volley", response);
                try {
                    JSONObject packet = new JSONObject(response);
                    //System.out.println(packet.length());
                    if (packet.length() == 4) {

                        JSONObject user_info = packet.getJSONObject("user_info");
                        String access_token;
                        String type;
                        String email;
                        String username;
                        String fullname;
                        String refresh_token;
                        access_token = (String) packet.get("access_token");
                        refresh_token = (String) packet.get("refresh_token");
                        type = (String) user_info.get("type");
                        email = (String) user_info.get("email");
                        username = (String) user_info.get("username");
                        fullname = (String) user_info.get("full_name");

                        //System.out.println(access_token+" "+type+" "+email +" "+ username+" "+fullname+" "+refresh_token);
                        user = new User_info(access_token, type, email, username, fullname, refresh_token);

                        switch (type) {
                            case "Employee":
                                get_employee_data(username,access_token);
                                break;
                            case "Parent":
                                get_parent_data(username,access_token);

                                break;
                            case "Student":
                                get_student_data(username,access_token);

                                break;
                            default:
                        }


                    } else {
                        Toast.makeText(getApplicationContext(), "Invalid Credentials", Toast.LENGTH_LONG).show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("Volley_error", error.toString());
                Toast.makeText(getApplicationContext(), "Log In Failed", Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> MyData = new HashMap<String, String>();
                MyData.put("client_id", "0519f18a7a36842285ce40b2d4b3d8ae18749ee9387c6bea1920589da1eefae8");
                MyData.put("client_secret", "b0846581a7b622559c1012d04ae4ed6c0828fdf3b9c839fe9d05093ce1f41ee9");
                MyData.put("grant_type", "password");
                MyData.put("username", username);
                MyData.put("password", password);
                MyData.put("redirect_uri", "http://" + school + ".cutebrains.com");
//                MyData.put("username", "T010");
//                MyData.put("password", "teacher123");
//                MyData.put("redirect_uri", "http://schools.cutebrains.com");

                return MyData;
            }
        };

        requestQueue.add(MyStringRequest);
    }

    private void get_student_data(String username, final String access_token) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String URL = "http://schools.cutebrains.com/api/users/" + username;
        System.out.println("Token token=\"" + access_token + '"');
        StringRequest MyStringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("Volley:", response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("Volley:", error.toString());
                    }
                }) {
            @Override
            public Map getHeaders() throws AuthFailureError {
                HashMap headers = new HashMap();
                headers.put("Content-Type", "application/x-www-form-urlencoded");
                headers.put("Authorization", "Token token=\"" + access_token + '"');
                return headers;
            }
        };

        requestQueue.add(MyStringRequest);

    }

    private void get_parent_data(String username, final String access_token) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String URL = "http://schools.cutebrains.com/api/users/" + username;
        System.out.println("Token token=\"" + access_token + '"');
        StringRequest MyStringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("Volley:", response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("Volley:", error.toString());
                    }
                }) {
            @Override
            public Map getHeaders() throws AuthFailureError {
                HashMap headers = new HashMap();
                headers.put("Content-Type", "application/x-www-form-urlencoded");
                headers.put("Authorization", "Token token=\"" + access_token + '"');
                return headers;
            }
        };

        requestQueue.add(MyStringRequest);

    }

    private void get_employee_data(String username, final String access_token) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String URL = "http://schools.cutebrains.com/api/users/" + username;
        System.out.println("Token token=\"" + access_token + '"');
        StringRequest MyStringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("Volley:", response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("Volley:", error.toString());
                    }
                }) {
            @Override
            public Map getHeaders() throws AuthFailureError {
                HashMap headers = new HashMap();
                headers.put("Content-Type", "application/x-www-form-urlencoded");
                headers.put("Authorization", "Token token=\"" + access_token + '"');
                return headers;
            }
        };

        requestQueue.add(MyStringRequest);

    }

}
