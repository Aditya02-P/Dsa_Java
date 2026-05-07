import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import java.util.Optional;

/**
 * ╔══════════════════════════════════════════════════════════════════╗
 * ║           JAVA STREAMS - COMPLETE REVISION SHEET                ║
 * ║   Covers: Creation · Intermediate · Terminal · Collectors        ║
 * ║   Spring Boot context included wherever applicable               ║
 * ╚══════════════════════════════════════════════════════════════════╝
 */
public class StreamsRevisionSheet {

    // ─────────────────────────────────────────────────────────────────
    // SAMPLE DOMAIN CLASSES  (simulates typical Spring Boot entities)
    // ─────────────────────────────────────────────────────────────────

    record Employee(String name, String department, double salary, int age, boolean active) {}

    record Order(String orderId, String customerId, double amount, String status) {}

    // ══════════════════════════════════════════════════════════════════
    // 1. STREAM CREATION
    // ══════════════════════════════════════════════════════════════════
    static void streamCreation() {
        System.out.println("\n══ 1. STREAM CREATION ══");

        // From Collection
        List<String> names = List.of("Alice", "Bob", "Charlie");
        Stream<String> fromList = names.stream();
        Stream<String> parallelStream = names.parallelStream(); // multi-threaded

        // From Array
        String[] arr = {"a", "b", "c"};
        Stream<String> fromArray = Arrays.stream(arr);

        // Stream.of()
        Stream<Integer> ofStream = Stream.of(1, 2, 3, 4, 5);

        // Stream.builder()
        Stream.Builder<String> builder = Stream.builder();
        builder.add("x").add("y").add("z");
        Stream<String> builtStream = builder.build();

        // Stream.generate() – infinite, needs limit
        Stream<Double> randoms = Stream.generate(Math::random).limit(5);

        // Stream.iterate() – infinite sequence
        Stream<Integer> evens = Stream.iterate(0, n -> n + 2).limit(10);
        // Java 9+: with predicate (stops when false)
        Stream<Integer> evensBounded = Stream.iterate(0, n -> n < 20, n -> n + 2);

        // Stream.concat()
        Stream<String> merged = Stream.concat(Stream.of("A", "B"), Stream.of("C", "D"));

        // IntStream / LongStream / DoubleStream (primitive streams – avoid boxing overhead)
        IntStream range = IntStream.range(1, 6);        // 1,2,3,4,5
        IntStream rangeClosed = IntStream.rangeClosed(1, 5); // 1,2,3,4,5
        LongStream longRange = LongStream.range(0L, 100L);

        // From String characters (useful in Spring for parsing)
        IntStream chars = "hello".chars(); // returns int codepoints

        System.out.println("IntStream sum 1-5: " + IntStream.rangeClosed(1, 5).sum());
    }

    // ══════════════════════════════════════════════════════════════════
    // 2. INTERMEDIATE OPERATIONS  (lazy – execute only when terminal runs)
    // ══════════════════════════════════════════════════════════════════
    static void intermediateOperations() {
        System.out.println("\n══ 2. INTERMEDIATE OPERATIONS ══");

        List<Employee> employees = List.of(
                new Employee("Alice",   "Engineering", 90000, 30, true),
                new Employee("Bob",     "HR",          55000, 45, true),
                new Employee("Charlie", "Engineering", 75000, 28, false),
                new Employee("Diana",   "HR",          60000, 35, true),
                new Employee("Eve",     "Engineering", 95000, 40, true),
                new Employee("Frank",   "Marketing",   50000, 25, true),
                new Employee("Grace",   "Marketing",   50000, 25, true)  // duplicate salary/age
        );

        // ── filter() ── keeps elements matching predicate
        List<Employee> active = employees.stream()
                .filter(Employee::active)   // method reference
                .filter(e -> e.salary() > 60000)
                .toList();
        System.out.println("Active & salary>60k: " + active.stream().map(Employee::name).toList());

        // ── map() ── transforms each element (changes type allowed)
        List<String> deptNames = employees.stream()
                .map(Employee::department)
                .toList();

        List<Double> raisedSalaries = employees.stream()
                .map(e -> e.salary() * 1.10) // 10% raise
                .toList();
        System.out.println("After 10% raise: " + raisedSalaries);

        // ── mapToInt / mapToLong / mapToDouble ── avoids boxing
        double avgSalary = employees.stream()
                .mapToDouble(Employee::salary)
                .average()
                .orElse(0);
        System.out.println("Avg salary: " + avgSalary);

        int totalAge = employees.stream()
                .mapToInt(Employee::age)
                .sum();
        System.out.println("Total age: " + totalAge);

        // ── flatMap() ── flatten nested structures (Stream<Stream<T>> → Stream<T>)
        List<List<String>> nested = List.of(
                List.of("Spring", "Boot"),
                List.of("Java", "Streams"),
                List.of("REST", "API")
        );
        List<String> flat = nested.stream()
                .flatMap(Collection::stream)
                .toList();
        System.out.println("FlatMapped: " + flat);

        // flatMap with Optional (very common in Spring Boot service layer)
        List<Optional<String>> optionals = List.of(
                Optional.of("value1"), Optional.empty(), Optional.of("value2")
        );
        List<String> presentValues = optionals.stream()
                .flatMap(Optional::stream) // Java 9+
                .toList();
        System.out.println("Present optionals: " + presentValues);

        // ── flatMapToInt ──
        List<int[]> arrays = List.of(new int[]{1,2}, new int[]{3,4}, new int[]{5});
        int[] merged = arrays.stream()
                .flatMapToInt(Arrays::stream)
                .toArray();
        System.out.println("FlatMapToInt: " + Arrays.toString(merged));

        // ── distinct() ── removes duplicates (uses equals/hashCode)
        List<String> depts = employees.stream()
                .map(Employee::department)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Distinct depts: " + depts);

        // ── sorted() ── natural order
        List<String> sortedNames = employees.stream()
                .map(Employee::name)
                .sorted()
                .collect(Collectors.toList());

        // ── sorted(Comparator) ── custom order
        List<Employee> bySalaryDesc = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::salary).reversed())
                .collect(Collectors.toList());
        System.out.println("Top earner: " + bySalaryDesc.get(0).name());

        // Chained comparator: primary dept, secondary salary desc
        List<Employee> multiSort = employees.stream()
                .sorted(Comparator.comparing(Employee::department)
                        .thenComparing(Comparator.comparingDouble(Employee::salary).reversed()))
                .collect(Collectors.toList());
        System.out.println("Multi-sorted: " + multiSort.stream().map(Employee::name).toList());

        // ── limit() ── truncate stream
        List<Employee> top3 = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::salary).reversed())
                .limit(3)
                .collect(Collectors.toList());

        // ── skip() ── skip first N elements (pagination!)
        List<Employee> page2 = employees.stream()
                .skip(2)   // skip(pageNumber * pageSize)
                .limit(2)  // limit(pageSize)
                .collect(Collectors.toList());
        System.out.println("Page 2 (size=2): " + page2.stream().map(Employee::name).toList());

        // ── peek() ── for debugging without breaking the chain
        long count = employees.stream()
                .filter(Employee::active)
                .peek(e -> System.out.println("  [peek] Processing: " + e.name()))
                .mapToDouble(Employee::salary)
                .filter(s -> s > 60000)
                .count();
        System.out.println("Count after peek: " + count);

        // ── mapMulti() ── Java 16+, efficient alternative to flatMap
        List<String> expanded = employees.stream()
                .<String>mapMulti((emp, consumer) -> {
                    consumer.accept(emp.name());
                    consumer.accept(emp.department());
                })
                .collect(Collectors.toList());
        System.out.println("mapMulti result size: " + expanded.size());

        // ── takeWhile() ── Java 9+: take while predicate true (stops at first false)
        List<Integer> taken = Stream.of(1, 2, 3, 4, 5, 1, 2)
                .takeWhile(n -> n < 4)
                .collect(Collectors.toList());
        System.out.println("takeWhile(<4): " + taken); // [1, 2, 3]

        // ── dropWhile() ── Java 9+: drop while predicate true
        List<Integer> dropped = Stream.of(1, 2, 3, 4, 5, 1, 2)
                .dropWhile(n -> n < 4)
                .collect(Collectors.toList());
        System.out.println("dropWhile(<4): " + dropped); // [4, 5, 1, 2]
    }

    // ══════════════════════════════════════════════════════════════════
    // 3. TERMINAL OPERATIONS  (eager – triggers execution)
    // ══════════════════════════════════════════════════════════════════
    static void terminalOperations() {
        System.out.println("\n══ 3. TERMINAL OPERATIONS ══");

        List<Integer> numbers = List.of(3, 1, 4, 1, 5, 9, 2, 6, 5, 3);
        List<Employee> employees = List.of(
                new Employee("Alice",   "Engineering", 90000, 30, true),
                new Employee("Bob",     "HR",          55000, 45, false),
                new Employee("Charlie", "Engineering", 75000, 28, true),
                new Employee("Diana",   "HR",          60000, 35, true)
        );

        // ── collect() ── most used; see Section 4 for details
        List<String> nameList = employees.stream()
                .map(Employee::name)
                .toList();

        // ── toList() ── Java 16+, returns unmodifiable list (preferred in modern code)
        List<String> immutableNames = employees.stream()
                .map(Employee::name)
                .toList();

        // ── forEach() ── action on each element (no return value)
        System.out.print("forEach: ");
        employees.stream()
                .filter(Employee::active)
                .forEach(e -> System.out.print(e.name() + " "));
        System.out.println();

        // ── forEachOrdered() ── guarantees encounter order (important for parallel streams)
        employees.parallelStream()
                .forEachOrdered(e -> System.out.print("[ordered]" + e.name() + " "));
        System.out.println();

        // ── count() ──
        long activeCount = employees.stream().filter(Employee::active).count();
        System.out.println("Active count: " + activeCount);

        // ── findFirst() ── returns Optional<T> of first element
        Optional<Employee> firstEngineer = employees.stream()
                .filter(e -> e.department().equals("Engineering"))
                .findFirst();
        firstEngineer.ifPresent(e -> System.out.println("First engineer: " + e.name()));

        // ── findAny() ── returns any element (faster in parallel streams)
        Optional<Employee> anyActive = employees.parallelStream()
                .filter(Employee::active)
                .findAny();

        // ── anyMatch() ── short-circuits on first true
        boolean hasHighEarner = employees.stream()
                .anyMatch(e -> e.salary() > 80000);
        System.out.println("Any >80k: " + hasHighEarner);

        // ── allMatch() ── short-circuits on first false
        boolean allActive = employees.stream()
                .allMatch(Employee::active);
        System.out.println("All active: " + allActive);

        // ── noneMatch() ── short-circuits on first true
        boolean noneNegativeSalary = employees.stream()
                .noneMatch(e -> e.salary() < 0);
        System.out.println("None negative salary: " + noneNegativeSalary);

        // ── min() / max() ──
        Optional<Employee> lowestPaid = employees.stream()
                .min(Comparator.comparingDouble(Employee::salary));
        Optional<Employee> highestPaid = employees.stream()
                .max(Comparator.comparingDouble(Employee::salary));
        System.out.println("Lowest paid: " + lowestPaid.map(Employee::name).orElse("none"));
        System.out.println("Highest paid: " + highestPaid.map(Employee::name).orElse("none"));

        // ── reduce() ── folds stream into single value
        // Identity + BinaryOperator
        int sum = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println("Sum: " + sum);

        double totalSalary = employees.stream()
                .map(Employee::salary)
                .reduce(0.0, Double::sum);
        System.out.println("Total salary: " + totalSalary);

        // Without identity – returns Optional (stream may be empty)
        Optional<Integer> product = numbers.stream()
                .reduce((a, b) -> a * b);

        // 3-arg reduce for parallel streams: identity, accumulator, combiner
        double parallelSum = employees.parallelStream()
                .reduce(0.0,
                        (acc, emp) -> acc + emp.salary(),  // accumulator
                        Double::sum);                        // combiner (merges partial results)
        System.out.println("Parallel salary sum: " + parallelSum);

        // ── toArray() ──
        Object[] arr = employees.stream().filter(Employee::active).toArray();
        Employee[] typedArr = employees.stream()
                .filter(Employee::active)
                .toArray(Employee[]::new);

        // ── Numeric terminal ops on primitive streams ──
        IntSummaryStatistics stats = employees.stream()
                .mapToInt(Employee::age)
                .summaryStatistics();
        System.out.println("Age stats → min:" + stats.getMin()
                + " max:" + stats.getMax()
                + " avg:" + stats.getAverage()
                + " sum:" + stats.getSum()
                + " count:" + stats.getCount());

        double salarySum  = employees.stream().mapToDouble(Employee::salary).sum();
        OptionalDouble avgAge = employees.stream().mapToInt(Employee::age).average();
        System.out.println("Avg age: " + avgAge.orElse(0));
    }

    // ══════════════════════════════════════════════════════════════════
    // 4. COLLECTORS (Collectors utility class)
    // ══════════════════════════════════════════════════════════════════
    static void collectorsDeep() {
        System.out.println("\n══ 4. COLLECTORS ══");

        List<Employee> employees = List.of(
                new Employee("Alice",   "Engineering", 90000, 30, true),
                new Employee("Bob",     "HR",          55000, 45, false),
                new Employee("Charlie", "Engineering", 75000, 28, true),
                new Employee("Diana",   "HR",          60000, 35, true),
                new Employee("Eve",     "Engineering", 95000, 40, true),
                new Employee("Frank",   "Marketing",   50000, 25, true)
        );

        // ── toList() / toUnmodifiableList() ──
        List<String> list = employees.stream()
                .map(Employee::name)
                .collect(Collectors.toList());

        List<String> unmodifiable = employees.stream()
                .map(Employee::name)
                .collect(Collectors.toUnmodifiableList());

        // ── toSet() / toUnmodifiableSet() ──
        Set<String> deptSet = employees.stream()
                .map(Employee::department)
                .collect(Collectors.toSet());
        System.out.println("Departments: " + deptSet);

        // ── toCollection() ── control exact collection type
        LinkedList<String> linkedList = employees.stream()
                .map(Employee::name)
                .collect(Collectors.toCollection(LinkedList::new));

        TreeSet<String> sortedSet = employees.stream()
                .map(Employee::name)
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println("TreeSet names: " + sortedSet);

        // ── toMap() ──
        // Key: name, Value: salary  (throws if duplicate key)
        Map<String, Double> nameToSalary = employees.stream()
                .collect(Collectors.toMap(Employee::name, Employee::salary));
        System.out.println("nameToSalary Alice: " + nameToSalary.get("Alice"));

        // With merge function (handles duplicate keys)
        Map<String, Double> deptToTotalSalary = employees.stream()
                .collect(Collectors.toMap(
                        Employee::department,
                        Employee::salary,
                        Double::sum          // merge: sum salaries for same dept
                ));
        System.out.println("Dept total salaries: " + deptToTotalSalary);

        // With merge + custom map type
        Map<String, Double> sortedMap = employees.stream()
                .collect(Collectors.toMap(
                        Employee::name,
                        Employee::salary,
                        (existing, replacement) -> existing, // keep existing on conflict
                        TreeMap::new                          // use TreeMap
                ));

        // ── toUnmodifiableMap() ──
        Map<String, Double> immutableMap = employees.stream()
                .collect(Collectors.toUnmodifiableMap(
                        Employee::name, Employee::salary));

        // ── groupingBy() ── groups into Map<K, List<V>>
        Map<String, List<Employee>> byDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::department));
        System.out.println("Engineering team: " +
                byDept.get("Engineering").stream().map(Employee::name).toList());

        // groupingBy with downstream collector
        Map<String, Long> countByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::department,
                        Collectors.counting()
                ));
        System.out.println("Count by dept: " + countByDept);

        Map<String, Double> avgSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::department,
                        Collectors.averagingDouble(Employee::salary)
                ));
        System.out.println("Avg salary by dept: " + avgSalaryByDept);

        Map<String, DoubleSummaryStatistics> statsByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::department,
                        Collectors.summarizingDouble(Employee::salary)
                ));
        System.out.println("Engineering stats: " + statsByDept.get("Engineering"));

        // groupingBy → collect into specific map type
        TreeMap<String, List<Employee>> sortedByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::department,
                        TreeMap::new,
                        Collectors.toList()
                ));

        // Nested groupingBy (multi-level grouping)
        Map<String, Map<Boolean, List<Employee>>> deptByActive = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::department,
                        Collectors.groupingBy(Employee::active)
                ));
        System.out.println("Engineering active: " +
                deptByActive.get("Engineering").get(true).stream().map(Employee::name).toList());

        // groupingBy → toMap (get max salary per dept as a Map)
        Map<String, Optional<Employee>> topEarnerByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::department,
                        Collectors.maxBy(Comparator.comparingDouble(Employee::salary))
                ));
        topEarnerByDept.forEach((dept, emp) ->
                System.out.println("Top in " + dept + ": " + emp.map(Employee::name).orElse("none")));

        // ── partitioningBy() ── special groupingBy with boolean key
        Map<Boolean, List<Employee>> activePartition = employees.stream()
                .collect(Collectors.partitioningBy(Employee::active));
        System.out.println("Active: " + activePartition.get(true).stream().map(Employee::name).toList());
        System.out.println("Inactive: " + activePartition.get(false).stream().map(Employee::name).toList());

        // With downstream
        Map<Boolean, Long> activeCount = employees.stream()
                .collect(Collectors.partitioningBy(
                        Employee::active,
                        Collectors.counting()
                ));
        System.out.println("Active/Inactive counts: " + activeCount);

        // ── joining() ── for strings
        String names = employees.stream()
                .map(Employee::name)
                .collect(Collectors.joining());
        System.out.println("Joined: " + names);

        String csvNames = employees.stream()
                .map(Employee::name)
                .collect(Collectors.joining(", "));
        System.out.println("CSV: " + csvNames);

        String formatted = employees.stream()
                .map(Employee::name)
                .collect(Collectors.joining(", ", "[", "]")); // delimiter, prefix, suffix
        System.out.println("Formatted: " + formatted);

        // ── counting() ──
        long total = employees.stream().collect(Collectors.counting());
        System.out.println("Total employees: " + total);

        // ── summingInt/Long/Double() ──
        double totalSalaries = employees.stream()
                .collect(Collectors.summingDouble(Employee::salary));

        // ── averagingInt/Long/Double() ──
        double avgAge = employees.stream()
                .collect(Collectors.averagingInt(Employee::age));
        System.out.println("Avg age: " + avgAge);

        // ── summarizingDouble() ──
        DoubleSummaryStatistics salaryStats = employees.stream()
                .collect(Collectors.summarizingDouble(Employee::salary));
        System.out.println("Salary stats: " + salaryStats);

        // ── minBy() / maxBy() ──
        Optional<Employee> youngest = employees.stream()
                .collect(Collectors.minBy(Comparator.comparingInt(Employee::age)));
        System.out.println("Youngest: " + youngest.map(Employee::name).orElse("none"));

        // ── mapping() ── transforms before downstream collector
        Map<String, List<String>> namesByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::department,
                        Collectors.mapping(Employee::name, Collectors.toList()) // map to name first
                ));
        System.out.println("Names by dept: " + namesByDept);

        // ── flatMapping() ── Java 9+, flatMap then collect
        // (Useful when each object has a list of items)
        Map<String, List<Character>> initials = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::department,
                        Collectors.flatMapping(
                                e -> e.name().chars().mapToObj(c -> (char) c).limit(1),
                                Collectors.toList()
                        )
                ));

        // ── filtering() ── Java 9+, filter inside downstream collector
        Map<String, List<Employee>> highEarnersByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::department,
                        Collectors.filtering(e -> e.salary() > 60000, Collectors.toList())
                ));
        System.out.println("High earners by dept: " +
                highEarnersByDept.entrySet().stream()
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                e -> e.getValue().stream().map(Employee::name).toList()
                        )));

        // ── collectingAndThen() ── post-process after collecting
        List<String> unmodifiableNameList = employees.stream()
                .map(Employee::name)
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        Collections::unmodifiableList
                ));

        // Get only first element after grouping
        Map<String, Optional<Employee>> firstByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::department,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                grp -> grp.stream().findFirst()
                        )
                ));

        // ── teeing() ── Java 12+: apply two collectors, merge results
        Map<String, Double> minMaxSalary = employees.stream()
                .collect(Collectors.teeing(
                        Collectors.minBy(Comparator.comparingDouble(Employee::salary)),
                        Collectors.maxBy(Comparator.comparingDouble(Employee::salary)),
                        (min, max) -> Map.of(
                                "min", min.map(Employee::salary).orElse(0.0),
                                "max", max.map(Employee::salary).orElse(0.0)
                        )
                ));
        System.out.println("Min/Max salary: " + minMaxSalary);

        // teeing for average (count + sum combined)
        double average = employees.stream()
                .collect(Collectors.teeing(
                        Collectors.summingDouble(Employee::salary),
                        Collectors.counting(),
                        (sum, count) -> count == 0 ? 0.0 : sum / count
                ));
        System.out.println("Manual average salary: " + average);
    }

    // ══════════════════════════════════════════════════════════════════
    // 5. COLLECTOR INTERFACE (custom collector)
    // ══════════════════════════════════════════════════════════════════
    static void customCollector() {
        System.out.println("\n══ 5. CUSTOM COLLECTOR ══");

        // Collector<T, A, R>
        //   T = input element type
        //   A = mutable accumulation (container) type
        //   R = result type

        // Custom collector: collect to comma-separated string
        Collector<String, StringBuilder, String> csvCollector = Collector.of(
                StringBuilder::new,                          // supplier: create container
                (sb, s) -> {                                  // accumulator: add element
                    if (!sb.isEmpty()) sb.append(", ");
                    sb.append(s);
                },
                (sb1, sb2) -> sb1.append(", ").append(sb2),  // combiner: for parallel
                StringBuilder::toString,                       // finisher: convert container to result
                Collector.Characteristics.UNORDERED           // optional characteristics
        );

        List<String> names = List.of("Alice", "Bob", "Charlie");
        String csv = names.stream().collect(csvCollector);
        System.out.println("Custom CSV collector: " + csv);

        // Collector characteristics:
        // IDENTITY_FINISH  – finisher is identity function (skip it)
        // UNORDERED        – order doesn't matter (allows optimizations)
        // CONCURRENT       – accumulator can be called concurrently (parallel safe)
    }

    // ══════════════════════════════════════════════════════════════════
    // 6. OPTIONAL (closely tied to streams in Spring Boot)
    // ══════════════════════════════════════════════════════════════════
    static void optionalUsage() {
        System.out.println("\n══ 6. OPTIONAL ══");

        List<Employee> employees = List.of(
                new Employee("Alice", "Engineering", 90000, 30, true),
                new Employee("Bob",   "HR",          55000, 45, false)
        );

        // Creation
        Optional<String> present = Optional.of("value");       // throws NPE if null
        Optional<String> nullable = Optional.ofNullable(null); // safe
        Optional<String> empty   = Optional.empty();

        // From stream (very common in Spring Boot repository layer)
        Optional<Employee> found = employees.stream()
                .filter(e -> e.name().equals("Alice"))
                .findFirst();

        // Consuming
        found.ifPresent(e -> System.out.println("Found: " + e.name()));

        // ifPresentOrElse – Java 9+
        found.ifPresentOrElse(
                e -> System.out.println("Employee: " + e.name()),
                () -> System.out.println("Not found")
        );

        // Transforming
        String name = found.map(Employee::name).orElse("Unknown");
        System.out.println("Name: " + name);

        Optional<String> dept = found.map(Employee::department);

        // flatMap (when mapper returns Optional)
        Optional<String> upperName = found
                .map(Employee::name)
                .map(String::toUpperCase);

        // filter
        Optional<Employee> highEarner = found
                .filter(e -> e.salary() > 80000);
        System.out.println("Is high earner: " + highEarner.isPresent());

        // Getting values
        Employee e1 = found.get();                                       // throws if empty
        Employee e2 = found.orElse(new Employee("Default","", 0, 0, false));
        Employee e3 = found.orElseGet(() -> new Employee("Lazy","",0,0,false)); // lazy
        // found.orElseThrow(() -> new RuntimeException("Not found"));  // throw custom exception

        // or() – Java 9+: return another Optional if empty
        Optional<Employee> result = found.or(() -> Optional.of(
                new Employee("Fallback", "Unknown", 0, 0, false)
        ));

        // stream() – Java 9+: bridge Optional → Stream (0 or 1 elements)
        found.stream()
                .map(Employee::name)
                .forEach(System.out::println);

        // isEmpty() – Java 11+
        boolean isEmpty = empty.isEmpty();
        System.out.println("isEmpty: " + isEmpty);
    }

    // ══════════════════════════════════════════════════════════════════
    // 7. PARALLEL STREAMS
    // ══════════════════════════════════════════════════════════════════
    static void parallelStreams() {
        System.out.println("\n══ 7. PARALLEL STREAMS ══");

        List<Integer> bigList = IntStream.rangeClosed(1, 1_000_000)
                .boxed()
                .collect(Collectors.toList());

        // Use parallelStream() for CPU-bound, large data, stateless operations
        long sum = bigList.parallelStream()
                .mapToLong(Integer::longValue)
                .sum();
        System.out.println("Parallel sum: " + sum);

        // Convert sequential → parallel mid-chain
        long count = bigList.stream()
                .filter(n -> n % 2 == 0)
                .parallel()          // switch to parallel
                .count();

        // ⚠ Pitfalls:
        // 1. Don't use parallel for small lists (overhead > benefit)
        // 2. Avoid shared mutable state (race conditions)
        // 3. Use forEachOrdered() if order matters in parallel
        // 4. Collectors.toList(), groupingBy etc. are thread-safe for parallel

        // Thread-safe accumulation with parallel
        double parallelAvg = bigList.parallelStream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0);
        System.out.println("Parallel avg: " + parallelAvg);
    }

    // ══════════════════════════════════════════════════════════════════
    // 8. SPRING BOOT REAL-WORLD PATTERNS
    // ══════════════════════════════════════════════════════════════════
    static void springBootPatterns() {
        System.out.println("\n══ 8. SPRING BOOT PATTERNS ══");

        List<Order> orders = List.of(
                new Order("O1", "C1", 250.0,  "COMPLETED"),
                new Order("O2", "C2", 100.0,  "PENDING"),
                new Order("O3", "C1", 450.0,  "COMPLETED"),
                new Order("O4", "C3", 75.0,   "CANCELLED"),
                new Order("O5", "C2", 320.0,  "COMPLETED")
        );

        // ── Pattern 1: DTO transformation (Entity → DTO) ──
        // In Spring Boot: employeeRepo.findAll().stream().map(EmployeeDTO::new).toList()
        record OrderSummary(String id, double amount) {}
        List<OrderSummary> summaries = orders.stream()
                .filter(o -> o.status().equals("COMPLETED"))
                .map(o -> new OrderSummary(o.orderId(), o.amount()))
                .toList();
        System.out.println("Completed order summaries: " + summaries.size());

        // ── Pattern 2: Revenue per customer ──
        Map<String, Double> revenueByCustomer = orders.stream()
                .filter(o -> o.status().equals("COMPLETED"))
                .collect(Collectors.groupingBy(
                        Order::customerId,
                        Collectors.summingDouble(Order::amount)
                ));
        System.out.println("Revenue by customer: " + revenueByCustomer);

        // ── Pattern 3: Validation / existence check ──
        boolean hasPending = orders.stream().anyMatch(o -> o.status().equals("PENDING"));
        System.out.println("Has pending orders: " + hasPending);

        // ── Pattern 4: Index/lookup map (avoid repeated DB calls) ──
        Map<String, Order> orderById = orders.stream()
                .collect(Collectors.toMap(Order::orderId, o -> o));
        System.out.println("Lookup O3: " + orderById.get("O3").amount());

        // ── Pattern 5: Batch processing & pagination ──
        int pageSize = 2;
        List<List<Order>> pages = IntStream.range(0, (int) Math.ceil((double) orders.size() / pageSize))
                .mapToObj(page -> orders.stream()
                        .skip((long) page * pageSize)
                        .limit(pageSize)
                        .toList())
                .toList();
        System.out.println("Pages: " + pages.size() + ", first page size: " + pages.get(0).size());

        // ── Pattern 6: Status distribution (for analytics APIs) ──
        Map<String, Long> statusDistribution = orders.stream()
                .collect(Collectors.groupingBy(Order::status, Collectors.counting()));
        System.out.println("Status distribution: " + statusDistribution);

        // ── Pattern 7: Top N query ──
        List<Order> top2Orders = orders.stream()
                .filter(o -> o.status().equals("COMPLETED"))
                .sorted(Comparator.comparingDouble(Order::amount).reversed())
                .limit(2)
                .toList();
        System.out.println("Top 2 orders: " + top2Orders.stream().map(Order::orderId).toList());

        // ── Pattern 8: Flat list of IDs from nested data ──
        Map<String, List<String>> customerOrders = orders.stream()
                .collect(Collectors.groupingBy(
                        Order::customerId,
                        Collectors.mapping(Order::orderId, Collectors.toList())
                ));
        System.out.println("Customer orders: " + customerOrders);

        // ── Pattern 9: Compute total + validate in one pass (teeing) ──
        record TotalAndCount(double total, long count) {}
        TotalAndCount result = orders.stream()
                .filter(o -> o.status().equals("COMPLETED"))
                .collect(Collectors.teeing(
                        Collectors.summingDouble(Order::amount),
                        Collectors.counting(),
                        TotalAndCount::new
                ));
        System.out.println("Total revenue: " + result.total() + " from " + result.count() + " orders");

        // ── Pattern 10: Converting list to comma-separated string (API response) ──
        String orderIds = orders.stream()
                .map(Order::orderId)
                .collect(Collectors.joining(", ", "Orders: [", "]"));
        System.out.println(orderIds);

        // ── Pattern 11: Deduplication by field ──
        // e.g. keep only one order per customer (first)
        List<Order> dedupedByCustomer = orders.stream()
                .collect(Collectors.toMap(
                        Order::customerId,
                        o -> o,
                        (existing, replacement) -> existing // keep first
                ))
                .values().stream()
                .toList();
        System.out.println("Deduped by customer count: " + dedupedByCustomer.size());

        // ── Pattern 12: Safe null handling with Optional + stream ──
        String customerIdInput = "C1"; // could come from request param
        Optional<Double> customerRevenue = Optional.ofNullable(revenueByCustomer.get(customerIdInput));
        customerRevenue.ifPresentOrElse(
                rev -> System.out.println("Revenue for " + customerIdInput + ": " + rev),
                () -> System.out.println("Customer not found")
        );
    }

    // ══════════════════════════════════════════════════════════════════
    // MAIN
    // ══════════════════════════════════════════════════════════════════
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║   JAVA STREAMS - REVISION SHEET          ║");
        System.out.println("╚══════════════════════════════════════════╝");

        streamCreation();
        intermediateOperations();
        terminalOperations();
        collectorsDeep();
        customCollector();
        optionalUsage();
        parallelStreams();
        springBootPatterns();

        System.out.println("\n✔ All sections executed successfully.");
    }
}