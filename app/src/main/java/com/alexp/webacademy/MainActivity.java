package com.alexp.webacademy;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    int testInc;
    TextView myTextVal;
    EditText sizeEdit;
    Matrix testMatrix;
    CheckBox chBox;

    private Button[][] mxButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView myText = (TextView) findViewById(R.id.tv);
        myText.setText("Value is ");
        myTextVal = (TextView) findViewById(R.id.tvVal);
        myTextVal.setText(Integer.toString(testInc));
        Button MyButton = (Button) findViewById(R.id.btnDoInc);
        sizeEdit = (EditText) findViewById(R.id.editVolume);
        chBox = (CheckBox) findViewById(R.id.checkBoxValue);
        MyButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                myTextVal.setText(Integer.toString(++testInc));
                return true;
            }
        });
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
        if (id == R.id.action_quit) {
            System.exit(0);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void doIncStart(View view) {
        myTextVal.setText(Integer.toString(++testInc));
        Toast.makeText(this, "Переменная увеличилась на 1", Toast.LENGTH_SHORT).show();
        Log.i("Inc", "testInc was increment by Button");
    }

    public void newMatrixGenerate(View view) {
        try {
            if (Integer.parseInt(sizeEdit.getText().toString()) > 0) {
                if (chBox.isChecked()) {
                    testMatrix = new Matrix(Integer.parseInt(sizeEdit.getText().toString()), 10, 99);
                } else {
                    testMatrix = new Matrix(Integer.parseInt(sizeEdit.getText().toString()));
                }
                drawGrid(testMatrix, (GridLayout) findViewById(R.id.idMatrix));
            } else {
                Toast.makeText(this, "Укажите правильно размер матрицы", Toast.LENGTH_SHORT).show();
                sizeEdit.requestFocus();
            }
        } catch (NumberFormatException err) {
            Toast.makeText(this, "Ошибка! Укажите правильно размер матрицы", Toast.LENGTH_SHORT).show();
            sizeEdit.requestFocus();
        }


    }

    public void drawGrid(final Matrix matrix, GridLayout grid) {
        GridLayout.Spec row;
        GridLayout.Spec column;
        GridLayout.LayoutParams gridLayoutParam;

        mxButtons = new Button[matrix.getnSize()][matrix.getnSize()];
        grid.removeAllViews();
        grid.setRowCount(matrix.getnSize());
        grid.setColumnCount(matrix.getnSize());
        grid.setVisibility(View.VISIBLE);
        Integer sumM = matrix.sumOfMatrix();
        Toast.makeText(this, "Сумма верхней медианной матрицы: " +
                sumM.toString(), Toast.LENGTH_SHORT).show();

        for (int i = 0; i < matrix.getnSize(); i++) {
            for (int j = 0; j < matrix.getnSize(); j++) {

                Button btnM = new Button(this);
                btnM.setText(Integer.toString(matrix.getMatricaItem(i, j)));

                if (i <= j) {
                    btnM.setBackgroundColor(Color.parseColor("#1EFF02"));
                } else {
                    btnM.setBackgroundColor(Color.parseColor("#FF639D"));
                }

                btnM.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Button VV = (Button) v;
                        randomBtn(VV);
                    }
                });

                mxButtons[i][j] = btnM;
                row = GridLayout.spec(i);
                column = GridLayout.spec(j);
                gridLayoutParam = new GridLayout.LayoutParams(row, column);
                grid.addView(btnM, gridLayoutParam);
            }
        }
    }

    public void randomBtn(Button btn) {
        for (int i = 0; i < mxButtons.length; i++) {
            for (int j = 0; j < mxButtons.length; j++) {
                if (mxButtons[i][j].equals(btn)) {
                    int a = (int) (Math.random() * 100);
                    testMatrix.setMatrica(a, i, j);
                    drawGrid(testMatrix, (GridLayout) findViewById(R.id.idMatrix));
                }
            }
        }
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        boolean result = super.onPrepareOptionsMenu(menu);
        menu.findItem(R.id.buttonDiagonal).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                startActivity(new Intent(MainActivity.this, ButtonsDiagonalView.class));
                return true;
            }
        });
        menu.findItem(R.id.loginActivity).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                intent.putExtra("textParam", "ReceiveText");
                startActivityForResult(intent, 101);
                return true;
            }
        });
        menu.findItem(R.id.calcActivity).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                startActivity(new Intent(MainActivity.this, CalcActivity.class));
                return true;
            }
        });
        return result;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null) {
            return;
        }
        if (requestCode == 101) {
            String name = data.getStringExtra("name");
            Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
        }
    }
}