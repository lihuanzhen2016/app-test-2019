from com.android.monkeyrunner import MonkeyRunner,MonkeyDevice,MonkeyImage
from com.android.monkeyrunner.easy import EasyMonkeyDevice,By

device = MonkeyRunner.waitForConnection()

print '******Case1: Use MonkeyDevice and MonkeyImage to check claculator result******'

print '---- start Calculator App'

device.startActivity('com.youdao.calculator/.activities.MainActivity')

print '---- calculator 3*8 with press method'

device.press('KEYCODE_3',MonkeyDevice.DOWN_AND_UP)
device.press('KEYCODE_NUMPAD_MULTIPLY',MonkeyDevice.DOWN_AND_UP)
device.press('KEYCODE_8',MonkeyDevice.DOWN_AND_UP)
device.press('KEYCODE_EQUALS',MonkeyDevice.DOWN_AND_UP)

image = device.takeSnapshot()
subimage = image.getSubImage((300,50,356,234))

print '---- calculator 4*6 with touch method'
device.touch(100,600,MonkeyDevice.DOWN_AND_UP)
device.touch(600,600,MonkeyDevice.DOWN_AND_UP)
device.touch(400,600,MonkeyDevice.DOWN_AND_UP)
device.touch(400,1000,MonkeyDevice.DOWN_AND_UP)

image2 = device.takeSnapshot()
subimage2 = image.getSubImage((300,50,356,234))

if (subimage2.sameAs(subimage,0.8)):
	print '[PASS] the result of 3*8 and 4*6 is equal!'
else:
	print '[Fail] the result of 3*8 and 4*6 is not equal!'
	
print '******Case2: Use EasyMonkeyDevice to check claculator result******'	

print '---- calculator 5*7 with EasyMonkeyDevice touch'

easy = EasyMonkeyDevice(device)
easy.touch(By.id('id/digit5'),MonkeyDevice.DOWN_AND_UP)
easy.touch(By.id('id/mul'),MonkeyDevice.DOWN_AND_UP)
easy.touch(By.id('id/digit7'),MonkeyDevice.DOWN_AND_UP)
easy.touch(By.id('id/equal'),MonkeyDevice.DOWN_AND_UP)

hv=device.getHierarchyViewer()
view = hv.findViewById('id/display')
str =view.children[1].namedProperties.get('text:mText').toString().encode('utf8')


if (str == '35'):
	print '[PASS] the result of 5*7 is correct!'
else:
	print '[Fail] the result of 5*7 is correct! the result is -- ' +str
	
easy.touch(By.id('id/clear'),MonkeyDevice.DOWN_AND_UP)
device.press('KEYCODE_BACK',MonkeyDevice.DOWN_AND_UP)