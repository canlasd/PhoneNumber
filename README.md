# PhoneNumber

App Highlights:

a) Clicking ADD NUMBER button inspects the user input for proper format and if it is a duplicate entry.  
If the input is OK, this will be added to a LinkedHashSet named newPhoneNumber.

b)  App uses two linkedHashSets :
LinkedHashSet usedPhoneNumber = new LinkedHashSet();
LinkedHashSet newPhoneNumber = new LinkedHashSet();

LinkedHashSet was used to prevent duplicate entries and also to organize the entries.

c)  Get Available Phone Number button gets an element from the newPhoneNumber set.  
It sends a toast message if there are no more entries available

d)  If there is a number available, this will displayed in a popup dialog.  
This number is then removed from newPhoneNumber and transferred to usedPhoneNumber.
