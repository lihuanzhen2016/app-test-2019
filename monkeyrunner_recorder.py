from com.android.monkeyrunner import MonkeyRunner
from com.android.monkeyrunner.recorder import MonkeyRecorder
device = MonkeyRunner.waitForConnection(5,'127.0.0.1:62001')
MonkeyRecorder.start(device)