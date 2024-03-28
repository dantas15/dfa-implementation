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
