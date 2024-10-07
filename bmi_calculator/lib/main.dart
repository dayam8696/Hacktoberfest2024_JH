import 'package:flutter/material.dart';

void main() {
  runApp(BMICalculator());
}

class BMICalculator extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: BMICalculatorHome(),
    );
  }
}

class BMICalculatorHome extends StatefulWidget {
  @override
  _BMICalculatorHomeState createState() => _BMICalculatorHomeState();
}

class _BMICalculatorHomeState extends State<BMICalculatorHome> {
  final TextEditingController heightController = TextEditingController();
  final TextEditingController weightController = TextEditingController();
  final TextEditingController ageController = TextEditingController();

  String? selectedGender;
  double? _bmi;
  String? _bmiCategory;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('BMI Calculator'),
        centerTitle: true,
        backgroundColor: Colors.green,
      ),
      body: Center(
        child: Padding(
          padding: const EdgeInsets.all(16.0),
          child: Container(
            width: 300, // Fixed width for compact design
            padding: EdgeInsets.all(16.0),
            decoration: BoxDecoration(
              color: Colors.white,
              borderRadius: BorderRadius.circular(12),
              boxShadow: [
                BoxShadow(
                  color: Colors.black12,
                  blurRadius: 10,
                  spreadRadius: 5,
                ),
              ],
            ),
            child: Column(
              mainAxisSize: MainAxisSize.min,
              children: <Widget>[
                Text(
                  'Enter your details',
                  style: TextStyle(
                    fontSize: 24,
                    fontWeight: FontWeight.bold,
                    color: Colors.green,
                  ),
                ),
                SizedBox(height: 20.0),

                // Age Input Field
                TextField(
                  controller: ageController,
                  keyboardType: TextInputType.number,
                  decoration: InputDecoration(
                    labelText: 'Age',
                    border: OutlineInputBorder(),
                    filled: true,
                    fillColor: Colors.green[50],
                  ),
                ),
                SizedBox(height: 16.0),

                // Gender Dropdown
                DropdownButtonFormField<String>(
                  value: selectedGender,
                  onChanged: (newValue) {
                    setState(() {
                      selectedGender = newValue;
                    });
                  },
                  decoration: InputDecoration(
                    labelText: 'Gender',
                    border: OutlineInputBorder(),
                    filled: true,
                    fillColor: Colors.green[50],
                  ),
                  items: [
                    DropdownMenuItem(
                      child: Text('Male'),
                      value: 'Male',
                    ),
                    DropdownMenuItem(
                      child: Text('Female'),
                      value: 'Female',
                    ),

                  ],
                ),
                SizedBox(height: 16.0),

                // Height Input Field
                TextField(
                  controller: heightController,
                  keyboardType: TextInputType.number,
                  decoration: InputDecoration(
                    labelText: 'Height (cm)',
                    border: OutlineInputBorder(),
                    filled: true,
                    fillColor: Colors.green[50],
                  ),
                ),
                SizedBox(height: 16.0),

                // Weight Input Field
                TextField(
                  controller: weightController,
                  keyboardType: TextInputType.number,
                  decoration: InputDecoration(
                    labelText: 'Weight (kg)',
                    border: OutlineInputBorder(),
                    filled: true,
                    fillColor: Colors.green[50],
                  ),
                ),
                SizedBox(height: 20.0),

                // Calculate Button
                ElevatedButton(
                  onPressed: calculateBMI,
                  child: Padding(
                    padding: const EdgeInsets.symmetric(horizontal: 30, vertical: 15),
                    child: Text('Calculate BMI', style: TextStyle(fontSize: 18)),
                  ),
                  style: ElevatedButton.styleFrom(
                    primary: Colors.green,
                    shape: RoundedRectangleBorder(
                      borderRadius: BorderRadius.circular(8),
                    ),
                  ),
                ),
                SizedBox(height: 20.0),

                // Display BMI Result
                if (_bmi != null)
                  Column(
                    children: [
                      Text(
                        'Your BMI is: ${_bmi!.toStringAsFixed(2)}',
                        style: TextStyle(fontSize: 24, color: Colors.black),
                      ),
                      SizedBox(height: 10),
                      if (_bmiCategory != null)
                        Text(
                          'Category: $_bmiCategory',
                          style: TextStyle(
                            fontSize: 20,
                            fontWeight: FontWeight.w600,
                            color: Colors.blueAccent,
                          ),
                        ),
                    ],
                  ),
              ],
            ),
          ),
        ),
      ),
    );
  }

  void calculateBMI() {
    double height = double.parse(heightController.text) / 100; // Convert cm to meters
    double weight = double.parse(weightController.text);
    double bmi = weight / (height * height);

    setState(() {
      _bmi = bmi;
      _bmiCategory = _getBMICategory(bmi);
    });
  }

  String _getBMICategory(double bmi) {
    int age = int.parse(ageController.text);
    if (selectedGender == null) return 'Please select gender';

    if (age < 18) {
      // For children/teenagers, use different BMI standards
      return _interpretForTeenagers(bmi);
    } else {
      // Adults, we can give general BMI interpretation
      return _interpretForAdults(bmi, selectedGender!);
    }
  }

  String _interpretForTeenagers(double bmi) {
    // General category for teenagers (could be more precise based on age ranges)
    if (bmi < 16) {
      return 'Underweight (Teen)';
    } else if (bmi >= 16 && bmi < 23) {
      return 'Healthy (Teen)';
    } else {
      return 'Overweight (Teen)';
    }
  }

  String _interpretForAdults(double bmi, String gender) {
    // Slightly different interpretation based on gender
    if (gender == 'Male') {
      if (bmi < 18.5) {
        return 'Underweight';
      } else if (bmi >= 18.5 && bmi < 25) {
        return 'Normal';
      } else if (bmi >= 25 && bmi < 30) {
        return 'Overweight';
      } else {
        return 'Obese';
      }
    } else if (gender == 'Female') {
      if (bmi < 18.0) {
        return 'Underweight';
      } else if (bmi >= 18.0 && bmi < 24) {
        return 'Normal';
      } else if (bmi >= 24 && bmi < 29) {
        return 'Overweight';
      } else {
        return 'Obese';
      }
    } else {
      // For 'Other' or non-binary
      if (bmi < 18.5) {
        return 'Underweight';
      } else if (bmi >= 18.5 && bmi < 25) {
        return 'Normal';
      } else if (bmi >= 25 && bmi < 30) {
        return 'Overweight';
      } else {
        return 'Obese';
      }
    }
  }
}
