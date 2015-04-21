# zookeeper-watcher-demo
zookeeper wather  demo

示例说明：zookeeper server端，client端每100毫秒写入数据，另一个client端watch节点数据变化

监听的结果是得到的数值是连续的、和数据生成端是一致的，并没有出现数值跳跃的情况。 


结论：只要实现Watcher, AsyncCallback.StatCallback2 个类的方法。节点值变化zookeeper会触发这2个回调函数。所以只要在一开始exists的watcher设定为自己(this)。然后wait()就可以了。


Example: zookeeper server terminal, client terminal every 100 milliseconds to write data, another client client watch node data changes

Monitoring results and numerical data is generated continuously, the end is the same, and no numerical jump conditions.

Conclusion: as long as the implementation of Watcher, a kind of method of AsyncCallback.StatCallback2. Changes in the value of the 2 zookeeper node will trigger a callback function. So just start with a exists watcher set for yourself (this). Then wait ().


