# I declare that my work contains no examples of misconduct, such as plagiarism, or collusion.
# Any code taken from other sources is referenced within my code soluton.
# Student ID: 20231691
# Date: 13/12/2023

from graphics import *
def studentversion():
    #Student version:
    try:
        credits=[0,20,40,60,80,100,120]
        stud_count=1
        while stud_count ==1:

            #Getting user input and checking if it is within the range
            pass_credits=int(input("Please enter your credits at pass: "))
            if pass_credits not in credits:
                print("Out of range.")
                break

            defer_credits=int(input("Please enter your credits at defer:  "))
            if defer_credits not in credits:
                print("Out of range.") 
                break
                
            fail_credits=int(input("Please enter your credits at fail:  "))
            if fail_credits not in credits:
                print("Out of range.")  
                break

            #Finding the total and checking if it is 120.
            total= pass_credits+defer_credits+fail_credits
            if total!=120:
                print("Incorrect total.")
                break
            
            #Finds and displays student's progression outcome
            if (pass_credits==120):
                progression_outcome="Progress"
            elif (pass_credits == 100):
                progression_outcome="Progress (module trailer)"
            elif (fail_credits>=80) and (fail_credits<=120):
                progression_outcome="Exclude"
            else:
                progression_outcome="Do not Progress- module retriever"
            print(progression_outcome)
            stud_count= stud_count+1
    
    except ValueError:
        #Avoids incorrect data types being entered
        print("Integer required")
    except:
        print("Some error occured")

count=0
progress_count=0
trailer_count=0
retriever_count=0
exclude_count=0
progress_list=[]
trailer_list=[]
retriever_list=[]
exclude_list=[]   
list_data=[progress_list,trailer_list,retriever_list,exclude_list]


#This function finds the progression outcomes for the staff version:
def progressionoutcomes(mark):

    global progress_count
    global trailer_count
    global retriever_count
    global exclude_count
    

    if (mark[0]==120):
        progression_outcome="Progress"
        progress_count=progress_count+1
        progress_list.append(f"Progress - {mark[0]}, {mark[1]}, {mark[2]}")

    elif (mark[0] == 100):
        progression_outcome="Progress (module trailer)"
        trailer_count= trailer_count+1
        trailer_list.append(f"Progress (module trailer) - {mark[0]}, {mark[1]}, {mark[2]}")

    elif (mark[2]>=80):
        progression_outcome="Exclude"
        exclude_count=exclude_count+1
        exclude_list.append(f"Exclude - {mark[0]}, {mark[1]}, {mark[2]}")

    else:
        progression_outcome="Do not Progress- module retriever"
        retriever_count=retriever_count+1
        retriever_list.append(f"Module retriever - {mark[0]}, {mark[1]}, {mark[2]}")

    print(progression_outcome)

version= input("Enter 'S' if you're student. Else if you're a staff member, enter 'T':    ").lower()
              
if version=="s":
    studentversion()

elif version=="t":  
    #staff version
    credits=[0,20,40,60,80,100,120]
    mark_list=[]

    #Getting user input and checking if it is within the range:
    for i in range(1):
        pass_credits=int(input("Enter your total PASS credits: "))
        if pass_credits not in credits:
            print("Out of range.")
            break

        defer_credits=int(input("Enter your total DEFER credits:  "))
        if defer_credits not in credits:
            print("Out of range.") 
            break
                
        fail_credits=int(input("Enter your total FAIL credits:  "))
        if fail_credits not in credits:
            print("Out of range.")  
            break

        #Finding the total and checking if it is 120.
        total= pass_credits+defer_credits+fail_credits
        if total!=120:
            print("Incorrect total.")
            break
        
        mark_list.append(pass_credits)
        mark_list.append(defer_credits)
        mark_list.append(fail_credits)
        
        #Finds and displays student's progression outcome and counts progression outcome values:
        progressionoutcomes(mark_list)

    status=input("Enter 'y' for yes or 'q' to quit and view results: ").lower()
    while (status!= 'q'):
        try:
            mark_list=[]
            #Getting user input and checking if it is within the range:
            pass_credits=int(input("Enter your total PASS credits: "))
            if pass_credits not in credits:
                print("Out of range.")
                break

            defer_credits=int(input("Enter your total DEFER credits:  "))
            if defer_credits not in credits:
                print("Out of range.") 
                break
                
            fail_credits=int(input("Enter your total FAIL credits:  "))
            if fail_credits not in credits:
                print("Out of range.")  
                break

            #Finding the total and checking if it is 120.
            total= pass_credits+defer_credits+fail_credits
            if total!=120:
                print("Incorrect total.")
                break
            
            mark_list.append(pass_credits)
            mark_list.append(defer_credits)
            mark_list.append(fail_credits)
        
            #Finds and displays student's progression outcome and counts progression outcome values:
            progressionoutcomes(mark_list)
            
            print("Would you like to enter another set of data?")
            status= input("Enter 'y' for yes or 'q' to quit and view results: ")
            
            
                
            count=count+1
    

        except ValueError:
            #Avoids incorrect data types being entered:
            print("Integer required")
        except:
            print("Some error occured")
    
    #Histogram:
    
    tot_outcomes=(progress_count+trailer_count+retriever_count+exclude_count)
    
    window= GraphWin("Histogram",700,700)

    #Drawing the base line
    baseline= Line(Point(25,600),Point(675,600))
    baseline.draw(window)

    #Finding the length of the bar:
    progress_len= 600-(progress_count*25)
    trailer_len=600-(trailer_count*25)
    retriever_len=600-(retriever_count*25)
    exclude_len=600-(exclude_count*25)

    #Drawing the rectangles
    progress_box=Rectangle(Point(50,600),Point(150,progress_len))
    progress_box.setFill("palegreen1")
    progress_box.draw(window)

    trailer_box=Rectangle(Point(175,600),Point(275,trailer_len))
    trailer_box.setFill("palegreen3")
    trailer_box.draw(window)

    retriever_box=Rectangle(Point(300,600),Point(400,retriever_len))
    retriever_box.setFill("olivedrab")
    retriever_box.draw(window)

    exclude_box=Rectangle(Point(425,600),Point(525,exclude_len))
    exclude_box.setFill("plum3")
    exclude_box.draw(window)

    #Text
    heading=Text(Point(150,100),"Histogram Results")
    heading.setSize(30)
    heading.setFill("grey")
    heading.draw(window)

    progress_label= Text(Point(100,625),"Progress")
    progress_label.setSize(16)
    progress_label.setFill("grey")
    progress_label.draw(window)

    trailer_label= Text(Point(225,625),"Trailer")
    trailer_label.setSize(16)
    trailer_label.setFill("grey")
    trailer_label.draw(window)

    retriever_label= Text(Point(350,625),"Retriever")
    retriever_label.setSize(16)
    retriever_label.setFill("grey")
    retriever_label.draw(window)

    exclude_label= Text(Point(475,625),"Excluded")
    exclude_label.setSize(16)
    exclude_label.setFill("grey")
    exclude_label.draw(window)

    progress_marker=Text(Point(100,progress_len-10),progress_count)
    progress_marker.setSize(16)
    progress_marker.setFill("grey")
    progress_marker.draw(window)

    trailer_marker=Text(Point(225,trailer_len-10),trailer_count)
    trailer_marker.setSize(16)
    trailer_marker.setFill("grey")
    trailer_marker.draw(window)

    retriever_marker=Text(Point(350,retriever_len-10),retriever_count)
    retriever_marker.setSize(16)
    retriever_marker.setFill("grey")
    retriever_marker.draw(window)

    exclude_marker=Text(Point(475,exclude_len-10),exclude_count)
    exclude_marker.setSize(16)
    exclude_marker.setFill("grey")
    exclude_marker.draw(window)

    outcomes_label=Text(Point(100,650),(str(tot_outcomes)+" outcomes in total."))
    outcomes_label.setSize(18)
    outcomes_label.setFill("grey")
    outcomes_label.draw(window)
    window.getMouse()

    #Part 2:
    print("Part 2: \n")
    
    for item in list_data:
        for data in item:
            print(data)
    
    #Part 3:
    print("\nPart 3: \n")
    
    myfile=open("progression_results.txt","w")
    for item in list_data:
        for data in item:
            myfile.write(data+"\n")
    myfile.close()
    readmyfile=open("progression_results.txt","r")
    print(readmyfile.read())
    readmyfile.close


else:
    print("Invalid character")    

