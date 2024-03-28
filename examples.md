## Binary: even numbers of 1's

- states

```
q0 q1
```

- alphabet

```
0 1
```

- transitions

```
(q0 0 q0) (q0 1 q1) (q1 0 q1) (q1 1 q0)
```

- initial state

```
q0
```

- acceptance states

```
q0
```

### Word examples

- should accept
  - `0110`
  - ``
  - `1010`
should not acccept
  - `1`
  - `0100`

## Word contains "aba"

- states

```
q0 q1 q2 q3
```

- alphabet

```
a b
```

- transitions

```
(q0 a q1) (q0 b q0) (q1 a q1) (q1 b q2) (q2 a q3) (q2 b q0) (q3 a q3) (q3 b q3)
```

- initial state

```
q0
```

- acceptance states

```
q3
```

### Word examples

- should accept
  - `aba`
  - `aaaababb`
  - `bbbaabbaba`
should not acccept
  - ``
  - `aabbaa`
