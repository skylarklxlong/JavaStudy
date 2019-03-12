#说明
Aspect Oriented Programming(AOP)，面向切面编程，是一个比较热门的话题。
AOP主要实现的目的是针对业务处理过程中的切面进行提取，它所面对的是处理过程中的某个步骤或阶段，
以获得逻辑过程中各部分之间低耦合性的隔离效果。

举个例子，我们现在提供一个服务查询学生信息的，但是我们希望记录有谁进行了这个查询。
如果按照传统的OOP的实现的话，那我们实现了一个查询学生信息的服务接口(StudentInfoService)
和其实现类（StudentInfoServiceImpl.java），同时为了要进行记录的话，那我们在实现类(StudentInfoServiceImpl.java)
中要添加其实现记录的过程。这样的话，假如我们要实现的服务有多个呢？那就要在每个实现的类都添加这些记录过程。
这样做的话就会有点繁琐，而且每个实现类都与记录服务日志的行为紧耦合，违反了面向对象的规则。
那么怎样才能把记录服务的行为与业务处理过程中分离出来呢？看起来好像就是查询学生的服务自己在进行，
但却是背后日志记录对这些行为进行记录，并且查询学生的服务不知道存在这些记录过程，
这就是我们要讨论AOP的目的所在。AOP的编程，好像就是把我们在某个方面的功能提出来与一批对象进行隔离，
这样与一批对象之间降低了耦合性，可以就某个功能进行编程。


AOP基本概念
1）aspect（切面）：实现了cross-cutting功能，是针对切面的模块。最常见的是logging模块，这样，程序按功能被分为好几层，如果按传统的继承的话，商业模型继承日志模块的话根本没有什么意义，而通过创建一个logging切面就可以使用AOP来实现相同的功能了。
2）jointpoint（连接点）：连接点是切面插入应用程序的地方，该点能被方法调用，而且也会被抛出意外。连接点是应用程序提供给切面插入的地方，可以添加新的方法。比如以上我们的切点可以认为是findInfo(String)方法。
3）advice（处理逻辑）：advice是我们切面功能的实现，它通知程序新的行为。如在logging里，logging advice包括logging的实现代码，比如像写日志到一个文件中。advice在jointpoint处插入到应用程序中。以上我们在MyHandler.java中实现了advice的功能
4）pointcut（切点）：pointcut可以控制你把哪些advice应用于jointpoint上去，通常你使用pointcuts通过正则表达式来把明显的名字和模式进行匹配应用。决定了那个jointpoint会获得通知。
5）introduction：允许添加新的方法和属性到类中。
6）target（目标类）：是指那些将使用advice的类，一般是指独立的那些商务模型。比如以上的StudentInfoServiceImpl.
7)proxy（代理类）：使用了proxy的模式。是指应用了advice的对象，看起来和target对象很相似。
8）weaving(插入）：是指应用aspects到一个target对象创建proxy对象的过程：complie time，classload time，runtime