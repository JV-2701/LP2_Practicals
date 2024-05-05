from chatterbot import ChatBot
from chatterbot.trainers import ListTrainer

chatbot = ChatBot("Chatter")
trainer = ListTrainer(chatbot)
trainer.train([
    "Hi",
    "Welcome, I am Chatter!!", ])
trainer.train([
    "I have some questions!",
    "Okay, How can I help you?"])
trainer.train([
    "How can I track my order?",
    "You can track your order by logging into your account on our website and navigating to the 'Order History' section. From there, you'll be able to see the status of your order and track its progress.", ])
trainer.train([
    "What payment methods do you accept?",
    "We accept various payment methods including credit cards, debit cards, PayPal, and bank transfers. You can choose the option that best suits you during the checkout process.", ])
trainer.train([
    "Do you offer international shipping?",
    " Yes, we offer international shipping to many countries. You can enter your address during the checkout process to see if we deliver to your location and to calculate shipping costs.", ])
trainer.train([
    " How do I return an item?",
    " To initiate a return, please visit the 'Returns & Exchanges' section of our website and follow the instructions provided. You'll need to fill out a return request form and wait for approval before shipping the item back to us.", ])
trainer.train([
    " Can I change or cancel my order after it has been placed?",
    "We process orders quickly to ensure prompt delivery, but if you need to make changes or cancel your order, please contact our customer support team as soon as possible. We'll do our best to accommodate your request.", ])
trainer.train([
    "Are your products covered by a warranty?",
    "Yes, many of our products come with a manufacturer's warranty. The duration and coverage of the warranty vary depending on the product. Please check the product description or contact us for more information.", ])
trainer.train([
    "Do you offer discounts or promotions?",
    "Yes, we regularly offer discounts and promotions on selected products. You can sign up for our newsletter or follow us on social media to stay updated on our latest offers.", ])
trainer.train([
    "How can I contact customer support?",
    "You can contact our customer support team via email, phone, or live chat. Our customer service representatives are available during business hours to assist you with any questions or concerns you may have.", ])
trainer.train([
    "Can I track the delivery of my order in real-time?",
    "Yes, once your order has been shipped, you'll receive a tracking number via email. You can use this tracking number to monitor the progress of your delivery in real-time on the carrier's website.", ])
trainer.train([
    "Are your products environmentally friendly?",
    " We strive to offer a selection of environmentally friendly products and work with suppliers who prioritize sustainability. You can find eco-friendly options by browsing our 'Green Products' category on our website.", ])
exit_conditions = (":q", "quit", "exit")
while True:
    query = input("> ")
    if query in exit_conditions:
        break
    else:
        print(f"<< { chatbot.get_response(query)}")
