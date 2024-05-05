def welcome():
     print("Welcome to the Medical Symptom Checker!")
def get_symptoms():
     print("Please enter your symptoms (separated by commas):")
     symptoms = input().split(',')
     return symptoms
def assess_symptoms(symptoms):
     severity = int(input("On a scale of 1 to 10, how severe are your symptoms? "))
     while int(severity) < 1 or int(severity) > 10:
         print("Invalid input. Please enter a number between 1 and 10.")
         severity = int(input("On a scale of 1 to 10, how severe are your symptoms? "))
         
     if severity >= 8:
         return "emergency"
     elif severity >= 5:
         return "urgent"
     else:
         return "homecare"
def recommend_action(severity):
     recommendations = {"emergency": "Based on your symptoms and severity, it's recommended to seek emergency medical attention immediately.",
             "urgent": "Based on your symptoms and severity, it's recommended to schedule an appointment with a doctor or visit an urgent care center.",
             "homecare": "Based on your symptoms and severity, you can manage them at home. However, if your symptoms worsen, please seek medical attention."
             }
     print(recommendations[severity])
def main():
     welcome()
     symptoms = get_symptoms()
     severity = assess_symptoms(symptoms)
     recommend_action(severity)
if __name__ == "__main__":
     main()
