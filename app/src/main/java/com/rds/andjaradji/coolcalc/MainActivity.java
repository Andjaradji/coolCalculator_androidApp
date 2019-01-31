package com.rds.andjaradji.coolcalc;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import org.apache.commons.lang3.StringUtils;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.RhinoException;
import org.mozilla.javascript.Scriptable;

import me.grantland.widget.AutofitTextView;


public class MainActivity extends Activity implements View.OnClickListener {
    private AutofitTextView displayCalcText;
    private AutofitTextView displayCalcResultText;

    private Button num0Btn;
    private Button num1Btn;
    private Button num2Btn;
    private Button num3Btn;
    private Button num4Btn;
    private Button num5Btn;
    private Button num6Btn;
    private Button num7Btn;
    private Button num8Btn;
    private Button num9Btn;
    private Button clearBtn;
    private Button dotBtn;
    private Button percentBtn;
    private Button bracketsBtn;

    private Boolean numberIsTrue = false;
    private Boolean operands = false;
    private Boolean dotPermission = true;

    private ImageButton signDivisionBtn;
    private ImageButton signMultiplyBtn;
    private ImageButton signAdditionBtn;
    private ImageButton signSubstractBtn;
    private ImageButton signEqualBtn;
    private ImageButton signBackspaceBtn;

    private String runningNumDisplay;
    private String equation;
    private String result;
    private String lastNum;
    private String lastCharType;
    private String reDisplay;
    private String reEq;
    private int matchBracketsPair;
    private int displayScreen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewInstantiating();
        resetAll();
        OnClikSetting();
        lastCharType = "empty";
        matchBracketsPair =0;


    }

    private void ViewInstantiating() {
        displayCalcText = (AutofitTextView) findViewById(R.id.calcDisplayID);
        displayCalcResultText = (AutofitTextView) findViewById(R.id.calcResultDisplayID);

        num0Btn = (Button) findViewById(R.id.btn0ID);
        num1Btn = (Button) findViewById(R.id.btn1ID);
        num2Btn = (Button) findViewById(R.id.btn2ID);
        num3Btn = (Button) findViewById(R.id.btn3ID);
        num4Btn = (Button) findViewById(R.id.btn4ID);
        num5Btn = (Button) findViewById(R.id.btn5ID);
        num6Btn = (Button) findViewById(R.id.btn6ID);
        num7Btn = (Button) findViewById(R.id.btn7ID);
        num8Btn = (Button) findViewById(R.id.btn8ID);
        num9Btn = (Button) findViewById(R.id.btn9ID);
        clearBtn = (Button) findViewById(R.id.btnClearID);
        dotBtn = (Button) findViewById(R.id.btnDotID);
        percentBtn = (Button) findViewById(R.id.btnPercentID);
        bracketsBtn = (Button) findViewById(R.id.btnBracketsID);

        signAdditionBtn = (ImageButton) findViewById(R.id.btnPlusID);
        signSubstractBtn = (ImageButton) findViewById(R.id.btnMinusID);
        signMultiplyBtn = (ImageButton) findViewById(R.id.btnMultiplyID);
        signDivisionBtn = (ImageButton) findViewById(R.id.btnDivisionID);
        signEqualBtn = (ImageButton) findViewById(R.id.btnEqualSign);
        signBackspaceBtn = (ImageButton) findViewById(R.id.btnBackspaceID);
    }

    //TODO: REWRITE THE ADDING OPERANDS METHOD

    //TODO: Reset All Value
    private void resetAll() {
        runningNumDisplay = "";
        equation = "";
        lastNum = "";
        displayCalcText.setText("");
        displayCalcResultText.setText("");
        numberIsTrue = false;
        operands = false;
        lastCharType = "";
        dotPermission = true;
        matchBracketsPair = 0;
        result="";
    }

    //TODO: View OnClick Setting
    private void OnClikSetting() {
        num0Btn.setOnClickListener(this);
        num1Btn.setOnClickListener(this);
        num2Btn.setOnClickListener(this);
        num3Btn.setOnClickListener(this);
        num4Btn.setOnClickListener(this);
        num5Btn.setOnClickListener(this);
        num6Btn.setOnClickListener(this);
        num7Btn.setOnClickListener(this);
        num8Btn.setOnClickListener(this);
        num9Btn.setOnClickListener(this);
        clearBtn.setOnClickListener(this);
        dotBtn.setOnClickListener(this);
        percentBtn.setOnClickListener(this);
        bracketsBtn.setOnClickListener(this);


        signEqualBtn.setOnClickListener(this);
        signDivisionBtn.setOnClickListener(this);
        signMultiplyBtn.setOnClickListener(this);
        signSubstractBtn.setOnClickListener(this);
        signAdditionBtn.setOnClickListener(this);
        signBackspaceBtn.setOnClickListener(this);


    }

    //TODO: OnClick
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn0ID:
                if (!displayCalcResultText.getText().toString().isEmpty()){
                    resetAll();
                }
                numberIsTrue = true;
                inputNumber("0");
                break;
            case R.id.btn1ID:
                if (!displayCalcResultText.getText().toString().isEmpty()){
                    resetAll();
                }
                numberIsTrue = true;
                inputNumber("1");
                break;
            case R.id.btn2ID:
                if (!displayCalcResultText.getText().toString().isEmpty()){
                    resetAll();
                }
                numberIsTrue = true;
                inputNumber("2");
                break;
            case R.id.btn3ID:
                if (!displayCalcResultText.getText().toString().isEmpty()){
                    resetAll();
                }
                numberIsTrue = true;
                inputNumber("3");
                break;
            case R.id.btn4ID:
                if (!displayCalcResultText.getText().toString().isEmpty()){
                    resetAll();
                }
                numberIsTrue = true;
                inputNumber("4");
                break;
            case R.id.btn5ID:
                if (!displayCalcResultText.getText().toString().isEmpty()){
                    resetAll();
                }
                numberIsTrue = true;
                inputNumber("5");
                break;
            case R.id.btn6ID:
                if (!displayCalcResultText.getText().toString().isEmpty()){
                    resetAll();
                }
                numberIsTrue = true;
                inputNumber("6");
                break;
            case R.id.btn7ID:
                if (!displayCalcResultText.getText().toString().isEmpty()){
                    resetAll();
                }
                numberIsTrue = true;
                inputNumber("7");
                break;
            case R.id.btn8ID:
                if (!displayCalcResultText.getText().toString().isEmpty()){
                    resetAll();
                }
                numberIsTrue = true;
                inputNumber("8");
                break;
            case R.id.btn9ID:
                if (!displayCalcResultText.getText().toString().isEmpty()){
                    resetAll();
                }
                numberIsTrue = true;
                inputNumber("9");
                break;
            case R.id.btnDotID:
                if (!displayCalcResultText.getText().toString().isEmpty()){
                    resetAll();
                }
                if (dotPermission){
                    inputNumber(".");
                    dotPermission = false;
                }

                break;
            case R.id.btnPlusID:
                if (!displayCalcResultText.getText().toString().isEmpty()){
                    runningNumDisplay = result;
                    equation = result;
                    operands = true;
                    inputNumber("+");

                } else {
                    operands = true;
                    inputNumber("+");
                }

                break;
            case R.id.btnMinusID:
                if (!displayCalcResultText.getText().toString().isEmpty()){
                    runningNumDisplay = result;
                    equation = result;
                    operands = true;
                    inputNumber("-");

                } else {
                    operands = true;
                    inputNumber("-");
                }
                break;
            case R.id.btnMultiplyID:
                if (!displayCalcResultText.getText().toString().isEmpty()){
                    runningNumDisplay = result;
                    equation = result;
                    operands = true;
                    inputNumber("*");

                } else {
                    operands = true;
                    inputNumber("*");
                }
                break;
            case R.id.btnDivisionID:
                if (!displayCalcResultText.getText().toString().isEmpty()){
                    runningNumDisplay = result;
                    equation = result;
                    operands = true;
                    inputNumber("/");

                } else {
                    operands = true;
                    inputNumber("/");
                }
                break;
            case R.id.btnPercentID:
                if (!displayCalcResultText.getText().toString().isEmpty()){
                    runningNumDisplay = result;
                    equation = result;
                    operands = true;
                    inputNumber("%");

                } else {
                    operands = true;
                    inputNumber("%");
                }
                break;
            case R.id.btnBracketsID:
                if (!displayCalcResultText.getText().toString().isEmpty()){
                    resetAll();
                }
                inputNumber("()");
                break;
            case R.id.btnBackspaceID:
                backspaceMethod ();
                break;
            case R.id.btnEqualSign:
                EvalResult();
                break;
            case R.id.btnClearID:
                resetAll();
                break;
        }

    }

    //TODO: Backspace Method

    private void backspaceMethod() {


            if (!displayCalcText.getText().toString().isEmpty()) {
                 if (equation.length() == 1){
                     resetAll();
                 }else if (equation.length() > 1){

                     //Using Straight Java Method
//                  reDisplay = runningNumDisplay.substring(0,runningNumDisplay.length()-1);

                     // Using Apache Library
                     reDisplay = StringUtils.chop(runningNumDisplay);
                     reEq = StringUtils.chop(equation);



                     displayCalcText.setText(reDisplay);
                     runningNumDisplay = reDisplay;
                     equation = reEq;



                  // Using Java StringBuilder Method
//                StringBuilder sb0 = new StringBuilder(runningNumDisplay);
//                sb0.deleteCharAt(runningNumDisplay.length() - 1);
//                runningNumDisplay = sb0.toString();
//                displayCalcText.setText(runningNumDisplay);
//                lastNum = runningNumDisplay.substring(runningNumDisplay.length() - 1);
//
//
//                StringBuilder sb1 = new StringBuilder(equation);
//                sb1.deleteCharAt(equation.length() - 1);
//                equation = sb1.toString();
                 }

            } else {
                resetAll();
            }


    }



    //TODO: Inputing Number
    private void inputNumber(String num) {
        checkDisplayScreen();
        checkLastCharType();
//        checkBracketsCondition();
        if (numberIsTrue){
            addingNumber (num);
        }else if (operands){
            addingOperands(num);
        }else if  (num.equals(".")){
            addingDot(num);
        }else if (num.equals("()")){
            addingBrackets (num);
        }

            displayCalcText.setText(runningNumDisplay);
            displayCalcResultText.setText("");
            if (runningNumDisplay.length() > 0) {
                lastNum = runningNumDisplay.substring(runningNumDisplay.length() - 1);
            }

           resetBooleanInput();
   }




    //TODO: Adding Number
    private void addingNumber(String num) {
        switch (displayScreen) {
            case 0:
                runningNumDisplay +=num;
                equation +=num;
                break;
            case 1:
                if (!num.equals("0")) {
                    runningNumDisplay = num;
                    equation = num;

                } else  {
                    runningNumDisplay += "";
                    equation += "";
                }
                break;
            case 2:
                if (lastCharType.equals("number")) {
                    runningNumDisplay += num;
                    equation += num;
                } else if (lastCharType.equals("operands")) {
                    if (lastNum.equals("%")) {
                        equation += "*" + num;
                        runningNumDisplay += num;
                    } else {
                        runningNumDisplay += num;
                        equation += num;
                    }
                } else if (lastCharType.equals("dot")) {
                    runningNumDisplay += num;
                    equation += num;
                } else if (lastCharType.equals("brackets")) {
                    if (lastNum.equals("(")) {
                        runningNumDisplay += num;
                        equation += num;
                    } else {
                        runningNumDisplay += "x" + num;
                        equation += "*" + num;
                    }
                }
                break;
        }
    }


    //TODO: Adding Operands Method
    private void addingOperands(String num) {
        switch (displayScreen){
            case 0:
                if (lastNum.equals("-")){
                    runningNumDisplay +=num;
                    equation +=num;
                }else {
                    runningNumDisplay +="";
                    equation +="";
                }
                break;
            case 1:
                runningNumDisplay += num;
                equation += num;
                break;
            case 2:
                if (lastCharType.equals("number")) {
                    switch (num) {
                        case "*":
                            equation += num;
                            runningNumDisplay += "x";
                            break;
                        case "/":
                            equation += num;
                            runningNumDisplay += "\u00F7";
                            break;
                        case "%":
                            equation += "/100";
                            runningNumDisplay += num;
                            break;
                        default:
                            equation += num;
                            runningNumDisplay += num;
                            break;
                    }
                } else if (lastCharType.equals("operands")){
                    if (lastNum.equals("%")){
                        runningNumDisplay += num;
                        equation +=num;
                    } else if (lastNum.equals("\u00F7") || (lastNum.equals("x"))){
                        if (num.equals("%")|| (num.equals("*")|| (num.equals("+")))){
                            runningNumDisplay = StringUtils.chop(runningNumDisplay) +  num;
                            equation = StringUtils.chop(equation)+num;
                        }else {
                            runningNumDisplay += num;
                            equation +=num;
                        }
                    } else if (lastNum.equals("+")||(lastNum.equals("-"))){
                        runningNumDisplay = StringUtils.chop(runningNumDisplay) +  num;
                        equation = StringUtils.chop(equation)+num;
                    }
                }else if (lastCharType.equals("dot")){
                    runningNumDisplay += num;
                    equation += num;
                }else if (lastCharType.equals("brackets")){
                    if (lastNum.equals("(")){
                        if (num.equals("-")){
                            runningNumDisplay +=num;
                            equation += num;
                        }else {
                            runningNumDisplay +="";
                            equation +="";
                        }
                    } else if (lastNum.equals(")")){
                        runningNumDisplay += num;
                        equation += num;
                    }
                }else if (lastCharType.equals("empty")){
                    if (num.equals("-")){
                        runningNumDisplay +=num;
                        equation += num;
                    }else {
                        runningNumDisplay +="";
                        equation +="";
                    }
                }
                break;
//        dotPermission = true;
    }
    }



    //TODO: Adding Dot
    private void addingDot(String num) {
        switch (displayScreen){
            case 0:
                runningNumDisplay += "0" + num;
                equation += "0" +num;
                break;
            case 1:
                runningNumDisplay += num;
                equation += num;
                break;
            case 2:
                if (lastCharType.equals("number")){
                    runningNumDisplay += num;
                    equation += num;
                } else if (lastCharType.equals("operands")){
                    runningNumDisplay += "0"+num;
                    equation += "0"+num;
                }else if (lastCharType.equals("dot")){
                    runningNumDisplay +="";
                    equation +="";
                }else if (lastCharType.equals("brackets")){
                    if (lastNum.equals("(")){
                        runningNumDisplay += "0"+num;
                        equation += "0"+num;
                    }else if (lastNum.equals(")")){
                        runningNumDisplay += "0"+num;
                        equation += "*0"+num;
                    }
                }
                break;
        }
    }

    //TODO: Adding Brackets
    private void addingBrackets(String num) {
        checkBracketsCondition();
        switch (displayScreen){
            case 0:
                runningNumDisplay += "(";
                equation += "(";
                break;
            case 1:
                runningNumDisplay += "x(";
                equation += "*(";
                break;
            case 2:
                if (lastCharType.equals("number")){
                    if (matchBracketsPair > 0){
                        closeBracketMethod();
                    } else {
                        runningNumDisplay += "x" + "(";
                        equation += "*" + "(";
                    }
                }else if (lastCharType.equals("operands")){
                    runningNumDisplay += num;
                    equation +=num;
                }else if (lastCharType.equals("dot")){
                    runningNumDisplay += num;
                    equation += "*" + num;

                }else if (lastCharType.equals("brackets")){
                    if (lastNum.equals("(")){
                        runningNumDisplay += "(";
                        equation += "(";
                    }else   {
                        if (matchBracketsPair > 0){
                            closeBracketMethod();
                        } else {
                            runningNumDisplay += "x" + "(";
                            equation += "*" + "(";
                        }
                    }
                }

                break;
        }
    }



    //TODO: Check Brackets Condition

    private void checkBracketsCondition() {

//        int numOpenBrackets = runningNumDisplay.length()-runningNumDisplay.replace("(","").length();
//        int numCloseBrackets = runningNumDisplay.length()-runningNumDisplay.replace(")","").length();


//          int numOpenBrackets = runningNumDisplay.length() - runningNumDisplay.replaceAll("\\(","").length();
//          int numCloseBrackets = runningNumDisplay.length() - runningNumDisplay.replaceAll("\\)","").length();

//          int numOpenBrackets = runningNumDisplay.split("\\(",-1).length-1;
//          int numCloseBrackets = runningNumDisplay.split("\\)",-1).length-1;


        int numOpenBrackets = StringUtils.countMatches(equation,"(");
        int numCloseBrackets = StringUtils.countMatches(equation,")");

        matchBracketsPair = numOpenBrackets-numCloseBrackets;

    }

    //TODO: Check Display Screen
    private void checkDisplayScreen(){
        if (displayCalcText.getText().toString().isEmpty()){
            displayScreen = 0;
        }else if (displayCalcText.getText().toString().equals("0")){
            displayScreen = 1;
        }else {
            displayScreen = 2;
        }

    }


    //TODO: Check Last Char Type
    private void checkLastCharType() {
        if (displayScreen == 0){
            lastCharType = "empty";
        } else {
            switch (lastNum) {
                case "0":
                    lastCharType = "number";
                    break;
                case "1":
                    lastCharType = "number";
                    break;
                case "2":
                    lastCharType = "number";
                    break;
                case "3":
                    lastCharType = "number";
                    break;
                case "4":
                    lastCharType = "number";
                    break;
                case "5":
                    lastCharType = "number";
                    break;
                case "6":
                    lastCharType = "number";
                    break;
                case "7":
                    lastCharType = "number";
                    break;
                case "8":
                    lastCharType = "number";
                    break;
                case "9":
                    lastCharType = "number";
                    break;
                case "-":
                    lastCharType = "operands";
                    break;
                case "+":
                    lastCharType = "operands";
                    break;
                case "x":
                    lastCharType = "operands";
                    break;
                case "\u00F7":
                    lastCharType = "operands";
                    break;
                case "%":
                    lastCharType = "operands";
                    break;
                case ".":
                    lastCharType = "dot";
                    break;
                case "(":
                    lastCharType = "brackets";
                    break;
                case ")":
                    lastCharType = "brackets";
                    break;
            }
        }
    }



    //TODO: Reset Boolean
    private void resetBooleanInput() {
        numberIsTrue = false;
        operands = false;
    }


    //TODO: Evaluating Result
    private void EvalResult() {
        if (equation.equals("(")){
            resetAll();
        }
        if (equation.length() > 0) {
            checkLastChar();
            checkBracketsCondition();
            if (matchBracketsPair > 0) {
                for (int i = 0; i < matchBracketsPair; i++) {
                    closeBracketMethod();
                }
                matchBracketsPair = 0;
            }

            Context rhino = Context.enter();
            rhino.setOptimizationLevel(-1);
            try {
                Scriptable scope = rhino.initStandardObjects();
                result = rhino.evaluateString(scope, equation, "JavaScript",
                        1, null).toString();

                String formatResult = result.substring(result.length()-2);
                if (formatResult.equals(".0")){
                    formatResult = result.substring(0,result.length()-2);
                    result =formatResult;
                }
                Log.d("COBALAST",equation);

                int dotIndex = result.indexOf(".");
                int resultIndex = result.length()-1;
                int numCharAfterDot = result.length()-1 - dotIndex;
                Log.d("COBARESULT", String.valueOf(numCharAfterDot));

                // Format result to maximum 11 number after dot
                if (numCharAfterDot > 11 ){
                    for (int i=dotIndex+11; i<resultIndex;i++){
                        result = StringUtils.chop(result);
                    }

                    // Format the character after dot to 10 and rounded the value if the 11th value is bigger than 5
                    String lastResultChar = result.substring(result.length() - 1);
                    int lastCharResult = Integer.parseInt(lastResultChar);
                    int last;
                    String lastChar;
                    if (lastCharResult >= 5) {
                        result = StringUtils.chop(result);
                        last = Integer.parseInt(result.substring(result.length()-1));
                        lastChar = String.valueOf(last+1);
                        result = StringUtils.chop(result) +lastChar;
                    } else {
                        result = StringUtils.chop(result);
                    }
                }




                displayCalcText.setText(runningNumDisplay);
                displayCalcResultText.setText("=" + " " + result);
                displayCalcResultText.setTextColor(getResources().getColor(R.color.colorDiff));



            } catch (RhinoException exception) {
                Context.exit();
                resetAll();
            }
        }

    }

    //TODO Check Last Char Before Evaluating Result
    private void checkLastChar() {
        if (equation.length() > 0) {
            lastNum = equation.substring(equation.length() - 1);
        }
          switch (lastNum) {
            case "+":
                  equation = StringUtils.chop(equation);
//                equation = equation.replace("+","");
//                runningNumDisplay = runningNumDisplay.replace("+","");
                break;
            case "-":
                  equation = StringUtils.chop(equation);
//                equation = equation.replace("-","");
//                runningNumDisplay = runningNumDisplay.replace("-","");
                String lastEQ = equation.substring(equation.length()-1);
                if (lastEQ.equals("(")){
                    int numBrackets = equation.length()-equation.replace("(","").length();
                    for (int i=equation.length(); i>=numBrackets;i--) {
                        equation = equation.replace("(", "");
                        equation = equation.replace("-","");
                    }

                    lastEQ = equation.substring(equation.length()-1);
                    if (lastEQ.equals("+")){
                        equation = equation.replace("+","");
                    } else if (lastEQ.equals("-")){
                        equation = equation.replace("-","");
                    } else if (lastEQ.equals("/")){
                        equation = equation.replace("/","");
                    } else if (lastEQ.equals("*")){
                        equation = equation.replace("*","");
                    }
                }
                break;
            case "/":
                equation = equation.replace("/","");
//                runningNumDisplay = runningNumDisplay.replace("\u00F7","");
                break;
            case "*":
                equation = equation.replace("*","");
//                runningNumDisplay = runningNumDisplay.replace("x","");
                break;
            case "(":
                int numOpenBrackets = equation.length()-equation.replace("(","").length();
                for (int i=equation.length(); i>=numOpenBrackets;i--) {
                    equation = equation.replace("(", "");
                    equation = equation.replace("-","");
                }
               String lastCharEq = equation.substring(equation.length() - 1);
                   if (lastCharEq.equals("+")){
                       equation = equation.replace("+","");
//                       runningNumDisplay = runningNumDisplay.replace("+","");
                   } else if (lastCharEq.equals("-")){
                       equation = equation.replace("-","");
//                       runningNumDisplay = runningNumDisplay.replace("-","");
                   } else if (lastCharEq.equals("/")){
                       equation = equation.replace("/","");
//                       runningNumDisplay = runningNumDisplay.replace("\u00F7","");
                   }else if (lastCharEq.equals("*")){
                       equation = equation.replace("*","");
//                       runningNumDisplay = runningNumDisplay.replace("x","");
                   }
            default:
                break;
        }
    }

    //TODO: Close Brackets Method
    private void closeBracketMethod() {
            runningNumDisplay += ")";
            equation += ")";
    }
}
