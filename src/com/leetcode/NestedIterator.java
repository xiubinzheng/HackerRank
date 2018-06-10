package com.leetcode;

import java.util.*;

/**
 * @author Anatoly Chernysh
 */
public class NestedIterator implements Iterator<Integer> {

    private List<Integer> list = new ArrayList<>();

    private Iterator<Integer> listIterator;

    public NestedIterator(List<NestedInteger> nestedList) {
        Iterator<NestedInteger> nestedIntegerIterator = nestedList.iterator();
        while (nestedIntegerIterator.hasNext()) {
            convertNestedList(nestedIntegerIterator.next());
        }

        listIterator = list.listIterator();
    }

    private void convertNestedList(NestedInteger nestedInteger) {
        if (nestedInteger.isInteger()) {
            list.add(nestedInteger.getInteger());
        }
        else {
            Iterator<NestedInteger> nestedIntegerIterator = nestedInteger.getList().iterator();
            while (nestedIntegerIterator.hasNext()) {
                convertNestedList(nestedIntegerIterator.next());
            }
        }
    }

    @Override
    public Integer next() {
        return listIterator.next();
    }

    @Override
    public boolean hasNext() {
        return listIterator.hasNext();
    }

    public static void main(String[] args) {
        List<NestedInteger> nestedList = new ArrayList<NestedInteger>();
        nestedList.add(new NestedInteger() {
            @Override
            public boolean isInteger() {
                return false;
            }

            @Override
            public Integer getInteger() {
                return null;
            }

            @Override
            public List<NestedInteger> getList() {
                List<NestedInteger> result = new ArrayList<NestedInteger>();
                result.add(new NestedInteger() {
                    @Override
                    public boolean isInteger() {
                        return true;
                    }

                    @Override
                    public Integer getInteger() {
                        return 1;
                    }

                    @Override
                    public List<NestedInteger> getList() {
                        return null;
                    }
                });
                result.add(new NestedInteger() {
                    @Override
                    public boolean isInteger() {
                        return true;
                    }

                    @Override
                    public Integer getInteger() {
                        return 1;
                    }

                    @Override
                    public List<NestedInteger> getList() {
                        return null;
                    }
                });
                return result;
            }
        });

        nestedList.add(new NestedInteger() {
            @Override
            public boolean isInteger() {
                return true;
            }

            @Override
            public Integer getInteger() {
                return 2;
            }

            @Override
            public List<NestedInteger> getList() {
                return null;
            }
        });

        nestedList.add(new NestedInteger() {
            @Override
            public boolean isInteger() {
                return false;
            }

            @Override
            public Integer getInteger() {
                return null;
            }

            @Override
            public List<NestedInteger> getList() {
                List<NestedInteger> result = new ArrayList<NestedInteger>();
                result.add(new NestedInteger() {
                    @Override
                    public boolean isInteger() {
                        return true;
                    }

                    @Override
                    public Integer getInteger() {
                        return 1;
                    }

                    @Override
                    public List<NestedInteger> getList() {
                        return null;
                    }
                });
                result.add(new NestedInteger() {
                    @Override
                    public boolean isInteger() {
                        return true;
                    }

                    @Override
                    public Integer getInteger() {
                        return 1;
                    }

                    @Override
                    public List<NestedInteger> getList() {
                        return null;
                    }
                });
                return result;
            }
        });


        NestedIterator nestedIterator = new NestedIterator(nestedList);
        while (nestedIterator.hasNext()) {
            System.out.println(nestedIterator.next());
        }
    }
}

interface NestedInteger {

    public boolean isInteger();

    public Integer getInteger();

    public List<NestedInteger> getList();

}