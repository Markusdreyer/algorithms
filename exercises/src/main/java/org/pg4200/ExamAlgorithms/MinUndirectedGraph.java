package org.pg4200.ExamAlgorithms;

import org.pg4200.les08.Graph;

import java.util.*;
import java.util.stream.Collectors;

public class MinUndirectedGraph<V> implements Graph<V> {

    protected Map<V,Set<V>> graph = new HashMap<>();

    @Override
    public void addVertex(V vertex) {
        Objects.requireNonNull(vertex);

        graph.putIfAbsent(vertex, new HashSet<>());
    }

    @Override
    public void addEdge(V from, V to) {
        Objects.requireNonNull(from);
        Objects.requireNonNull(to);

        addVertex(from);
        addVertex(to);

        graph.get(from).add(to);

        if(!from.equals(to)) {
            graph.get(to).add(from);
        }

    }

    @Override
    public int getNumberOfVertices() {
        return graph.size();
    }

    @Override
    public int getNumberOfEdges() {
        long edges = graph.values().stream()
                .mapToInt(e -> e.size())
                .sum();

        edges += graph.entrySet().stream()
                .filter(e -> e.getValue().contains(e.getKey()))
                .count();

        return (int) edges / 2;
    }

    @Override
    public void removeEdge(V from, V to) {
        Objects.requireNonNull(from);
        Objects.requireNonNull(to);

        Set<V> connectedFrom = graph.get(from);
        Set<V> connectedTo = graph.get(to);

        if(connectedFrom != null) {
            connectedFrom.remove(to);
        }

        if(connectedTo != null) {
            connectedTo.remove(from);
        }

    }

    @Override
    public void removeVertex(V vertex) {
        Objects.requireNonNull(vertex);

        if(! graph.containsKey(vertex)) {
            return;
        }

        graph.get(vertex).forEach(v -> graph.get(v).remove(v));

        graph.remove(vertex);
    }

    @Override
    public Collection<V> getAdjacents(V vertex) {
        Objects.requireNonNull(vertex);
        return graph.get(vertex);
    }

    @Override
    public List<V> findPathDFS(V start, V end) {


        return null;
    }

    @Override
    public List<V> findPathBFS(V start, V end) {
        return null;
    }

    @Override
    public Set<V> findConnected(V vertex) {
        return null;
    }

    @Override
    public Set<V> findConnected(Iterable<V> vertices) {
        return null;
    }
}
