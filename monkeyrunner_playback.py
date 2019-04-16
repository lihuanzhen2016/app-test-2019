import sys
from com.android.monkeyrunner import MonkeyRunner

CMD_MAP = {  
    "TOUCH": lambda dev, arg: dev.touch(**arg),  
    "DRAG": lambda dev, arg: dev.drag(**arg),  
    "PRESS": lambda dev, arg: dev.press(**arg),  
    "TYPE": lambda dev, arg: dev.type(**arg),  
    "WAIT": lambda dev, arg: MonkeyRunner.sleep(**arg)  
    }  
  
#Process a single file for the specified device.  
def process_file(fp, device):  
    for line in fp:  
        (cmd, rest) = line.split("|")  
        try:  
            rest = eval(rest)  
        except:  
            print ("unable to parse options")  
            continue  
  
        if cmd not in CMD_MAP:  
            print ("unknown command: " + cmd) 
            continue  
  
        CMD_MAP[cmd](device, rest)  
  
  
def main():  
    file = sys.argv[1]  
    fp = open(file, "r")  
  
    device = MonkeyRunner.waitForConnection()  
      
    process_file(fp, device)  
    fp.close();  
      
  
if __name__ == "__main__":  
    main()