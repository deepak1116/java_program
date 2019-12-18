import eel
import base64
import os
import sys
eel.init('web')




    
def find(namelength,array,arrlen):
    check = namelength
    i = namelength
    arraylength = arrlen
    count = 0
    while i > arraylength:
        if count is 0:
            i = check - arraylength
            count = 1
        else:
            i = i-arraylength

    i = i-1
    if i != arraylength - 1:
        for index in range(i,arraylength-1):
            array[index] = array[index+1]
    else:
        i = 0
    array.pop(arraylength-1)
    arraylength = arraylength -1
    if i != 0:
        for index in range(0,i):
            temp = array[0]
            for k in range(0,arraylength-1):
                array[k] = array[k+1]
            array[arraylength-1] = temp
    if arraylength != 1:
        find(namelength,array,arraylength)
    return array[0]

def resource_path(relative_path):
    try:
        base_path = sys._MEIPASS
    except Exception:
        base_path = os.path.abspath(".")

    return os.path.join(base_path, relative_path)
    

'''def resource_path(relative):
    return os.path.join(
        os.environ.get(
            "_MEIPASS2",
            os.path.abspath(".")
        ),
        relative
    )'''
def selectImage(answer):
    if answer == "Friends":
        imagefile = "friends.png"
    elif answer == "Love":
        imagefile = "love.png"
    elif answer == "Affection":
        imagefile = "affection.png"
    elif answer == "Marriage":
        imagefile = "marriage.png"
    elif answer == "Enemy":
        imagefile = "enemy.png"
    elif answer == "Sister":
        imagefile = "sis.png"
    with open(resource_path(imagefile), "rb") as img_file:
        encoded = base64.b64encode(img_file.read()).decode('utf-8')
    return "data:image/png;base64, " + encoded




@eel.expose
def flames(romeo,juliet):
    arr = [ "Friend", "Love", "Affection", "Marriage", "Enemy", "Sister" ]
    firstlen = len(romeo)
    secondlen = len(juliet)
    count = 0
    for i in romeo:
        for j in juliet:
            if i is j :
                i = '!'
                j = '!'
                count += 2
                break
    finallen = firstlen + secondlen - count
    answer = find(finallen,arr,6)
    imagename = selectImage(answer)
    return imagename


eel.start('index.html', size=(1500, 600))
            
        

      
