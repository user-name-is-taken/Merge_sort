import collections
class controller(object):
    def __init__(self,genToSort):
        assert isinstance(genToSort, collections.Iterator)#use next(iter)
        self.genToSort = genToSort
        self.sortStruct = [self.makeBaseList(),]
        self.makeFirstSortList()
        self.makeSortList()
        pass
    def _next(self):
        pass

    

    """below here is the setup"""
    def makeBaseList(self):
        """makes the first element of sortStruct
contains all the natural lists in genToSort
this is a list of lists
"""
        bigList = [collections.deque(),]#has appendleft()
        bigList[-1].append(next(self.genToSort))
        for i in self.genToSort:
            if i <= bigList[-1][0]:
                bigList[-1].appendleft(i)
            else:
                if not i>= bigList[-1][-1]:
                    bigList.append(collections.deque())
                bigList[-1].append(i)
        return bigList
    def makeFirstSortList(self):
        """pass"""
        s = self.sortStruct[0]
        curList = list()
        for i in range(len(s[-1]),2):
            if s[i] < s[i+1]:
                curList.append(i)
            else:
                curList.append(i+1)
        self.sortStruct.append(curList)
        pass

    def makeSortLists(self):
        """makes all the next elements sortStruct
These are used for actually sorting genToSort.
Each element is a list representing layer in the sorting hierarchy"""
        s = self.sortStruct
        
        while len(s)>3:
            curList = list()
            lisLen = len(s[-1])
            lisLenMod2 = lisLen % 2
            for i in range(lisLen - lisLenMod2 ,2):
                if s[0][s[-1][i]] < s[0][s[-1][i+1]]:
                    curList.append( s[-1][i])
                else:
                    curList.append( s[-1][i+1])
            if lisLenMod2:
                
            self.sortStruct.append(curList)

"""you need to use these classes for odd numbers of elements"""
            
class Base(object):
    def add(self,val):
        pass

class Worker(object):
    def __init__(self):
        pass
